package io.github.lionstats.db.dao.pagination

import org.jooq.Field
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
    }
}

enum class SortedFieldOrder {
    Asc,
    Desc
}

data class SortedField<Z>(
    val field: Field<Z>,
    val value: Z,
    val order: SortedFieldOrder = SortedFieldOrder.Asc
)

class SortedFields(val sortedFieldList: List<SortedField<*>> = listOf()) {
    fun <Z> addSortedField(sortedField: SortedField<Z>): SortedFields {
        return SortedFields(sortedFieldList + listOf(sortedField))
    }
}

class CursorPagination(val limit: Int, val sortedFields: SortedFields, cursor: Cursor?)