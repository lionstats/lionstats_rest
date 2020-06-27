package io.github.lionstats.db.dao

import org.jooq.TableRecord
import java.lang.Exception

data class DeleteResponse<R : TableRecord<R>, T, P : DAOPojo<T>>(
    val primaryKeyValue: T?,
    val pojo: P,
    val record: R
)

sealed class MultiDeleteResult<R : TableRecord<R>, T, RP : DAOPojo<T>>

data class SuccessfulDeleteResult<R : TableRecord<R>, T, P : DAOPojo<T>>(
    val primaryKeyValue: T?,
    val pojo: P,
    val record: R
) : MultiDeleteResult<R, T, P>()

data class FailedDeleteResult<R : TableRecord<R>, T, P : DAOPojo<T>, IP : DAOPojo<T>>(
    val primaryKeyValue: T?,
    val pojo: IP,
    val exception: Exception
) : MultiDeleteResult<R, T, P>()

data class MultiDeleteResponse<R : TableRecord<R>, T, P : DAOPojo<T>>(
    val inserts: List<MultiDeleteResult<R, T, P>>
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