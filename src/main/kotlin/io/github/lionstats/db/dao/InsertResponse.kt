package io.github.lionstats.db.dao

import org.jooq.TableRecord
import java.lang.Exception

data class InsertResponse<R : TableRecord<R>, T, P : DAOPojo<T>>(
    val primaryKeyValue: T?,
    val pojo: P,
    val record: R
)

sealed class MultiInsertResult<R : TableRecord<R>, T, RP : DAOPojo<T>>

data class SuccessfulInsertResult<R : TableRecord<R>, T, P : DAOPojo<T>>(
    val primaryKeyValue: T?,
    val pojo: P,
    val record: R
) : MultiInsertResult<R, T, P>()

data class FailedInsertResult<R : TableRecord<R>, T, P : DAOPojo<T>, IP : DAOPojo<T>>(
    val primaryKeyValue: T?,
    val pojo: IP,
    val exception: Exception
) : MultiInsertResult<R, T, P>()

data class MultiInsertResponse<R : TableRecord<R>, T, P : DAOPojo<T>>(
    val inserts: List<MultiInsertResult<R, T, P>>
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