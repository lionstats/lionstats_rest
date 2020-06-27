package io.github.lionstats.db.dao

import org.jooq.TableRecord
import java.lang.Exception

data class UpsertResponse<R : TableRecord<R>, T, P : DAOPojo<T>>(
    val primaryKeyValue: T?,
    val pojo: P,
    val record: R
)

sealed class MultiUpsertResult<R : TableRecord<R>, T, RP : DAOPojo<T>>

data class SuccessfulUpsertResult<R : TableRecord<R>, T, P : DAOPojo<T>>(
    val primaryKeyValue: T?,
    val pojo: P,
    val record: R
) : MultiUpsertResult<R, T, P>()

data class FailedUpsertResult<R : TableRecord<R>, T, P : DAOPojo<T>, IP : DAOPojo<T>>(
    val primaryKeyValue: T?,
    val pojo: IP,
    val exception: Exception
) : MultiUpsertResult<R, T, P>()

data class MultiUpsertResponse<R : TableRecord<R>, T, P : DAOPojo<T>>(
    val inserts: List<MultiUpsertResult<R, T, P>>
) {
    fun noFailures(): Boolean {
        return inserts.filter {
            when (it) {
                is FailedInsertResult<*, *, *, *> -> true
                else -> false
            }
        }.count() > 0
    }
}