package io.github.lionstats.db.dao

import org.jooq.TableRecord
import java.lang.Exception

data class UpdateResponse<R : TableRecord<R>, T, P : DAOPojo<T>>(
    val primaryKeyValue: T?,
    val pojo: P,
    val record: R
)

sealed class MultiUpdateResult<R : TableRecord<R>, T, RP : DAOPojo<T>>

data class SuccessfulUpdateResult<R : TableRecord<R>, T, P : DAOPojo<T>>(
    val primaryKeyValue: T?,
    val pojo: P,
    val record: R
) : MultiUpdateResult<R, T, P>()

data class FailedUpdateResult<R : TableRecord<R>, T, P : DAOPojo<T>, IP : DAOPojo<T>>(
    val primaryKeyValue: T?,
    val pojo: IP,
    val exception: Exception
) : MultiUpdateResult<R, T, P>()

data class MultiUpdateResponse<R : TableRecord<R>, T, P : DAOPojo<T>>(
    val inserts: List<MultiUpdateResult<R, T, P>>
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