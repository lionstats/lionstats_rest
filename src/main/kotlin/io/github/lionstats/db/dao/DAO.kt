package io.github.lionstats.db.dao

import io.github.lionstats.db.dao.pagination.Cursor
import io.github.lionstats.db.dao.pagination.CursorPagination
import io.github.lionstats.db.dao.pagination.Pagination
import io.github.lionstats.db.dao.pagination.SortedFieldOrder
import org.jooq.*
import org.jooq.impl.DSL
import java.lang.Exception
import java.math.BigInteger

interface DAOPojo<T> {
    fun primaryKeyValue(): T?

    fun primaryKeyField(): Field<T>?

    fun insertCallback() {}
    fun updateCallback() {}
    fun upsertCallback() {}
    fun deleteCallback() {}
}

data class FetchParameters(
    val whereQuery: WhereQuery = WhereQuery(),
    val pagination: Pagination?
)

interface FetchResponseBase<P : DAOPojo<*>> {
    val count: Long
    val data: List<P>
}

sealed class FetchResponse<P : DAOPojo<*>>

data class CursorPaginatedFetchResponse<P : DAOPojo<*>>(
    override val count: Long,
    override val data: List<P>,
    val cursor: Cursor,
    val encodedCursor: String = cursor.encode()
) : FetchResponseBase<P>, FetchResponse<P>()

data class DefaultFetchResponse<P : DAOPojo<*>>(override val count: Long, override val data: List<P>) :
    FetchResponseBase<P>, FetchResponse<P>()

interface DAO<R : TableRecord<R>, P : DAOPojo<T>, T> {
    val dslContext: DSLContext

    fun defaultReturnFields(): List<SelectFieldOrAsterisk> {
        return listOf(getTable().asterisk())
    }

    fun insertReturnFields(): List<SelectFieldOrAsterisk> = defaultReturnFields()
    fun updateReturnFields(): List<SelectFieldOrAsterisk> = defaultReturnFields()
    fun upsertReturnFields(): List<SelectFieldOrAsterisk> = defaultReturnFields()
    fun deleteReturnFields(): List<SelectFieldOrAsterisk> = defaultReturnFields()
    fun findReturnFields(): List<SelectFieldOrAsterisk> = defaultReturnFields()
    fun fetchReturnFields(): List<SelectFieldOrAsterisk> = defaultReturnFields()

    fun insert(pojo: P) = insert(pojo, getPojoClass(), insertReturnFields())
    fun insertMulti(pojo: List<P>): MultiInsertResponse<R, T, P> =
        insertMulti(pojo, getPojoClass(), insertReturnFields())

    fun <CIP : DAOPojo<T>, CRP : DAOPojo<T>> insert(
        pojo: CIP,
        returningPojoClass: Class<CRP>,
        fields: List<SelectFieldOrAsterisk>
    ): InsertResponse<R, T, CRP> {
        pojo.insertCallback()
        val record = createCustomRecord(pojo)

        val insertedRecord = dslContext.insertInto(getTable()).set(record).returning(fields).fetchOne()

        val insertedPojo = insertedRecord.into(returningPojoClass)

        return InsertResponse(
            primaryKeyValue = insertedPojo.primaryKeyValue(),
            pojo = insertedPojo,
            record = insertedRecord
        )
    }

    fun <CIP : DAOPojo<T>, CRP : DAOPojo<T>> insertMulti(
        pojo: List<CIP>,
        returningPojoClass: Class<CRP>,
        fields: List<SelectFieldOrAsterisk>
    ): MultiInsertResponse<R, T, CRP> {
        val inserts: List<MultiInsertResult<R, T, CRP>> = pojo.map {
            try {
                val insertResult: InsertResponse<R, T, CRP> = insert(it, returningPojoClass, fields)
                SuccessfulInsertResult(
                    primaryKeyValue = insertResult.primaryKeyValue,
                    pojo = insertResult.pojo,
                    record = insertResult.record
                )
            } catch (e: Exception) {
                FailedInsertResult<R, T, CRP, CIP>(
                    primaryKeyValue = it.primaryKeyValue(),
                    pojo = it,
                    exception = e
                )
            }
        }
        return MultiInsertResponse(inserts)
    }


    fun update(pojo: P) = update(pojo, getPojoClass(), updateReturnFields())
    fun updateMulti(pojo: List<P>) = updateMulti(pojo, getPojoClass(), updateReturnFields())
    fun <CIP : DAOPojo<T>, CRP : DAOPojo<T>> update(
        pojo: CIP,
        returningPojoClass: Class<CRP>,
        fields: List<SelectFieldOrAsterisk>
    ): UpdateResponse<R, T, CRP> {
        pojo.updateCallback()
        val record = createCustomRecord(pojo)

        val updateRecord =
            dslContext.update(getTable()).set(record).where(pojo.primaryKeyField()?.eq(pojo.primaryKeyField()))
                .returning(fields).fetchOne()

        val updatePojo = updateRecord.into(returningPojoClass)

        return UpdateResponse(
            primaryKeyValue = updatePojo.primaryKeyValue(),
            pojo = updatePojo,
            record = updateRecord
        )
    }

    fun <CIP : DAOPojo<T>, CRP : DAOPojo<T>> updateMulti(
        pojo: List<CIP>,
        returningPojoClass: Class<CRP>,
        fields: List<SelectFieldOrAsterisk>
    ): MultiUpdateResponse<R, T, CRP> {
        val updates: List<MultiUpdateResult<R, T, CRP>> = pojo.map {
            try {
                val updateResult = update(it, returningPojoClass, fields)
                SuccessfulUpdateResult(
                    primaryKeyValue = updateResult.primaryKeyValue,
                    pojo = updateResult.pojo,
                    record = updateResult.record
                )
            } catch (e: Exception) {
                FailedUpdateResult<R, T, CRP, CIP>(
                    primaryKeyValue = it.primaryKeyValue(),
                    pojo = it,
                    exception = e
                )
            }
        }

        return MultiUpdateResponse(updates)
    }


    fun upsert(pojo: P) = upsert(pojo, getPojoClass(), upsertReturnFields())
    fun upsertMulti(pojo: List<P>, inTransaction: Boolean) = upsertMulti(pojo, getPojoClass(), upsertReturnFields())
    fun <CIP : DAOPojo<T>, CRP : DAOPojo<T>> upsert(
        pojo: CIP,
        returningPojoClass: Class<CRP>,
        fields: List<SelectFieldOrAsterisk>
    ): UpsertResponse<R, T, CRP> {
        pojo.upsertCallback()

        val record = createCustomRecord(pojo)

        val upsertedRecord =
            dslContext.insertInto(getTable()).set(record).onDuplicateKeyUpdate().set(record).returning(fields)
                .fetchOne()

        val upsertedPojo = upsertedRecord.into(returningPojoClass)

        return UpsertResponse(
            primaryKeyValue = upsertedPojo.primaryKeyValue(),
            pojo = upsertedPojo,
            record = upsertedRecord
        )
    }

    fun <CIP : DAOPojo<T>, CRP : DAOPojo<T>> upsertMulti(
        pojo: List<CIP>,
        returningPojoClass: Class<CRP>,
        fields: List<SelectFieldOrAsterisk>
    ): MultiUpsertResponse<R, T, CRP> {
        val upserts: List<MultiUpsertResult<R, T, CRP>> = pojo.map {
            try {
                val upsertResult: UpsertResponse<R, T, CRP> = upsert(it, returningPojoClass, fields)
                SuccessfulUpsertResult(
                    primaryKeyValue = upsertResult.primaryKeyValue,
                    pojo = upsertResult.pojo,
                    record = upsertResult.record
                )
            } catch (e: Exception) {
                FailedUpsertResult<R, T, CRP, CIP>(
                    primaryKeyValue = it.primaryKeyValue(),
                    pojo = it,
                    exception = e
                )
            }
        }

        return MultiUpsertResponse(upserts)
    }


    fun delete(pojo: P) = delete(pojo, getPojoClass(), deleteReturnFields())
    fun deleteMulti(pojo: List<P>) = deleteMulti(pojo, getPojoClass(), deleteReturnFields())

    fun <CIP : DAOPojo<T>, CRP : DAOPojo<T>> delete(
        pojo: CIP,
        returningPojoClass: Class<CRP>,
        fields: List<SelectFieldOrAsterisk>
    ): DeleteResponse<R, T, CRP> {
        pojo.deleteCallback()
        val record = createCustomRecord(pojo)

        val deleteRecord =
            dslContext.delete(getTable()).where(pojo.primaryKeyField()?.eq(pojo.primaryKeyValue())).returning(fields)
                .fetchOne()

        val deletePojo = deleteRecord.into(returningPojoClass)

        return DeleteResponse(
            primaryKeyValue = deletePojo.primaryKeyValue(),
            pojo = deletePojo,
            record = deleteRecord
        )
    }

    fun <CIP : DAOPojo<T>, CRP : DAOPojo<T>> deleteMulti(
        pojo: List<CIP>,
        returningPojoClass: Class<CRP>,
        fields: List<SelectFieldOrAsterisk>
    ): MultiDeleteResponse<R, T, CRP> {
        val deletes: List<MultiDeleteResult<R, T, CRP>> = pojo.map {
            try {
                val deleteResult = delete(it, returningPojoClass, fields)
                SuccessfulDeleteResult(
                    primaryKeyValue = deleteResult.primaryKeyValue,
                    pojo = deleteResult.pojo,
                    record = deleteResult.record
                )
            } catch (e: Exception) {
                FailedDeleteResult<R, T, CRP, CIP>(
                    primaryKeyValue = it.primaryKeyValue(),
                    pojo = it,
                    exception = e
                )
            }
        }

        return MultiDeleteResponse(deletes)
    }

    fun <CP : DAOPojo<T>> fetch(
        fetchParams: FetchParameters,
        returningPojoClass: Class<CP>,
        fields: List<SelectFieldOrAsterisk>
    ): FetchResponse<CP> {
        val whereCondition = fetchParams.whereQuery.condition

        val orderBy = when (fetchParams.pagination) {
            is CursorPagination -> {
                fetchParams.pagination.sortedFields.map {
                    when (it.order) {
                        SortedFieldOrder.Asc -> it.field.asc()
                        SortedFieldOrder.Desc -> it.field.desc()
                    }
                }
            }
            else -> listOf<SortField<*>>()
        }

        val query = when (fetchParams.pagination) {
            is CursorPagination -> {
                if (fetchParams.pagination.cursor == null) {
                    dslContext.select(fields).from(getTable()).where(whereCondition).orderBy(orderBy)
                        .limit(fetchParams.pagination.limit)
                } else {
                    dslContext.select(fields).from(getTable()).where(whereCondition).orderBy(orderBy)
                        .seek(*fetchParams.pagination.seekValues().toTypedArray())
                        .limit(fetchParams.pagination.limit)
                }
            }
            else ->
                dslContext.select(fields).from(getTable()).where(whereCondition).orderBy(orderBy)
        }

        val records = query.fetch()

        val pojos = records.into(returningPojoClass)

        return when (fetchParams.pagination) {
            is CursorPagination -> {
                CursorPaginatedFetchResponse(
                    count = pojos.count().toLong(),
                    data = pojos,
                    cursor = Cursor.fromRecord(records.last(), fetchParams.pagination.sortedFields)
                )
            }
            else -> {
                DefaultFetchResponse(
                    count = pojos.count().toLong(),
                    data = pojos
                )
            }
        }
    }

    fun getTable(): Table<R>

    //    fun getPrimaryKeyClass(): TableField<R, T>
    fun getPojoClass(): Class<P>

    //
    fun createRecord(pojo: P): R = dslContext.use {
        it.newRecord(getTable(), pojo)
    }

    fun <CP : DAOPojo<T>> createCustomRecord(pojo: CP): R = dslContext.use {
        it.newRecord(getTable(), pojo)
    }
}