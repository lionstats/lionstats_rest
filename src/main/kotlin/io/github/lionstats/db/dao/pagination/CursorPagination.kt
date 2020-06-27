package io.github.lionstats.db.dao.pagination

import org.jooq.Field
import org.jooq.Param
import org.jooq.Record
import org.jooq.impl.DSL
import java.util.*

class Cursor(val fieldValues: Map<String, String> = mapOf()) {
    fun encode(): String {
        val encoded = fieldValues.map { (field, value) ->
            "$field<=>$value"
        }.joinToString { "," }
        return Base64.getEncoder().encodeToString(encoded.toByteArray(Charsets.UTF_8))
    }

    companion object {
        fun decode(encodedCursor: String): Cursor {
            val rawCursor = String(Base64.getDecoder().decode(encodedCursor))
            val fieldValues = rawCursor.split(";").map {
                val fieldValue = it.split("<=>")
                fieldValue[0] to fieldValue[1]
            }.toMap()
            return Cursor(fieldValues)
        }

        fun fromRecord(record: Record, sortedFields: List<SortedField<*>>): Cursor {
            val fieldValues = sortedFields.map {
                it.field.name to record.get(it.field).toString()
            }.toMap()

            return Cursor(fieldValues)
        }
    }
}

enum class SortedFieldOrder {
    Asc,
    Desc
}

data class SortedField<Z>(
    val field: Field<Z>,
    val order: SortedFieldOrder = SortedFieldOrder.Asc
)


class CursorPagination(val limit: Int, val sortedFields: List<SortedField<*>> = listOf(), val cursor: Cursor? = null) :
    Pagination {

    fun setCursor(newCursor: Cursor?): CursorPagination {
        return CursorPagination(limit, sortedFields, newCursor)
    }

    fun seekValues(): List<Param<*>> {
        if (cursor == null) throw NullPointerException("Cursor can't be null when generating seek values")
        else {
            return sortedFields.map {
                val value = cursor.fieldValues[it.field.name]
                val field = it.field
                DSL.`val`(value, field)
            }
        }
    }
}