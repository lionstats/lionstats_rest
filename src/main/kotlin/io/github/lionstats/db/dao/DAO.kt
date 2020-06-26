package io.github.lionstats.db.dao

import org.jooq.*
import java.math.BigInteger

interface DAOPojo<T> {
    fun primaryKeyValue(): T?

    fun <R : TableRecord<R>> primaryKeyClass(): TableField<R, T>?
}

interface DAO<R : TableRecord<R>, P : DAOPojo<T>, T> {
    fun defaultReturnFields(): List<SelectFieldOrAsterisk>

    fun insertReturnFields(): List<SelectFieldOrAsterisk> = defaultReturnFields()
    fun updateReturnFields(): List<SelectFieldOrAsterisk> = defaultReturnFields()
    fun findReturnFields(): List<SelectFieldOrAsterisk> = defaultReturnFields()
    fun fetchReturnFields(): List<SelectFieldOrAsterisk> = defaultReturnFields()

    fun insert(pojo: P)
    fun insert(pojo: List<P>, inTransaction: Boolean)
    fun <CP : DAOPojo<T>> insert(pojo: P, returningPojoClass: Class<CP>, fields: List<SelectFieldOrAsterisk>)
    fun <CP : DAOPojo<T>> insert(
        pojo: List<P>,
        returningPojoClass: Class<CP>,
        fields: List<SelectFieldOrAsterisk>,
        inTransaction: Boolean
    )

    fun update(pojo: P)
    fun update(pojo: List<P>, inTransaction: Boolean)
    fun <CP : DAOPojo<T>> update(pojo: P, returningPojoClass: Class<CP>, fields: List<SelectFieldOrAsterisk>)
    fun <CP : DAOPojo<T>> update(
        pojo: List<P>,
        returningPojoClass: Class<CP>,
        fields: List<SelectFieldOrAsterisk>,
        inTransaction: Boolean
    )

    fun upsert(pojo: P)
    fun upsert(pojo: List<P>, inTransaction: Boolean)
    fun <CP : DAOPojo<T>> upsert(pojo: P, returningPojoClass: Class<CP>, fields: List<SelectFieldOrAsterisk>)
    fun <CP : DAOPojo<T>> upsert(
        pojo: List<P>,
        returningPojoClass: Class<CP>,
        fields: List<SelectFieldOrAsterisk>,
        inTransaction: Boolean
    )

    fun delete(pojo: P)
    fun delete(pojo: List<P>, inTransaction: Boolean)
    fun <CP : DAOPojo<T>> delete(pojo: P, returningPojoClass: Class<CP>, fields: List<SelectFieldOrAsterisk>)
    fun <CP : DAOPojo<T>> delete(
        pojo: List<P>,
        returningPojoClass: Class<CP>,
        fields: List<SelectFieldOrAsterisk>,
        inTransaction: Boolean
    )

    fun deleteByPrimaryKey(primaryKeyValue: T)
    fun deleteByPrimaryKey(primaryKeyValue: List<T>, inTransaction: Boolean)
    fun <CP : DAOPojo<T>> deleteByPrimaryKey(
        primaryKeyValue: T,
        returningPojoClass: Class<CP>,
        fields: List<SelectFieldOrAsterisk>
    )

    fun <CP : DAOPojo<T>> deleteByPrimaryKey(
        primaryKeyValue: List<P>,
        returningPojoClass: Class<CP>,
        fields: List<SelectFieldOrAsterisk>,
        inTransaction: Boolean
    )

    fun exists(pojo: P)
    fun exists(pojo: List<P>)

    fun existsByPrimaryKey(primaryKeyValue: T)
    fun existsByPrimaryKey(primaryKeyValue: List<T>, inTransaction: Boolean)

    fun count(): BigInteger

    fun findByPrimaryKey(primaryKeyValue: T)
    fun <CP : DAOPojo<T>> findByPrimaryKey(
        primaryKeyValue: T,
        returningPojoClass: Class<CP>,
        fields: List<SelectFieldOrAsterisk>
    )

    fun <Z> findBy(field: Field<Z>, value: Z)
    fun <Z, CP : DAOPojo<T>> findBy(
        field: Field<Z>,
        value: Z,
        returningPojoClass: Class<CP>,
        fields: List<SelectFieldOrAsterisk>
    )

    fun fetch(fetchParams: Any)
    fun <CP : DAOPojo<T>> fetch(fetchParams: Any, returningPojoClass: Class<CP>, fields: List<SelectFieldOrAsterisk>)

    fun getTable(): Table<R>
    fun getPrimaryKeyClass(): TableField<R, T>
    fun getPojoClass(): Class<P>
    fun createRecord(pojo: R): R
}