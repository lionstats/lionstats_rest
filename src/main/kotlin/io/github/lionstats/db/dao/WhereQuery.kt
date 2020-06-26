package io.github.lionstats.db.dao

import org.jooq.Condition
import org.jooq.Field
import org.jooq.impl.DSL

class WhereQuery (val condition: Condition = DSL.noCondition())

interface WhereCondition<Z> {
    val field: Field<Z>

    fun condition(): Condition
}

data class Equal<Z>(override val field: Field<Z>, val value: Z) : WhereCondition<Z> {
    override fun condition(): Condition = field.eq(value)
}

data class NotEqual<Z>(override val field: Field<Z>, val value: Z) : WhereCondition<Z> {
    override fun condition(): Condition = field.notEqual(value)
}

data class Greater<Z>(override val field: Field<Z>, val value: Z) : WhereCondition<Z> {
    override fun condition(): Condition = field.greaterThan(value)
}

data class GreaterOrEqual<Z>(override val field: Field<Z>, val value: Z) : WhereCondition<Z> {
    override fun condition(): Condition = field.greaterOrEqual(value)
}

data class Less<Z>(override val field: Field<Z>, val value: Z) : WhereCondition<Z> {
    override fun condition(): Condition = field.lessThan(value)
}

data class LessOrEqual<Z>(override val field: Field<Z>, val value: Z) : WhereCondition<Z> {
    override fun condition(): Condition = field.lessOrEqual(value)
}

data class Like<Z>(override val field: Field<Z>, val value: String) : WhereCondition<Z> {
    override fun condition(): Condition = field.like(value)
}

data class LikeIgnoreCase<Z>(override val field: Field<Z>, val value: String) : WhereCondition<Z> {
    override fun condition(): Condition = field.likeIgnoreCase(value)
}

data class Between<Z>(override val field: Field<Z>, val minValue: Z, val maxValue: Z) : WhereCondition<Z> {
    override fun condition(): Condition = field.between(minValue, maxValue)
}

data class NotBetween<Z>(override val field: Field<Z>, val minValue: Z, val maxValue: Z) : WhereCondition<Z> {
    override fun condition(): Condition = field.notBetween(minValue, maxValue)

}

data class In<Z>(override val field: Field<Z>, val values: List<Z>) : WhereCondition<Z> {
    override fun condition(): Condition = field.`in`(values)
}

data class NotIn<Z>(override val field: Field<Z>, val values: List<Z>) : WhereCondition<Z> {
    override fun condition(): Condition = field.notIn(values)
}

class WhereQueryBuilder(private val conditions: List<WhereCondition<*>> = listOf()) {

    fun <Z> addCondition(whereCondition: WhereCondition<Z>): WhereQueryBuilder {
        return WhereQueryBuilder(conditions + listOf(whereCondition))
    }

    fun build(): WhereQuery {
        val condition = conditions.fold(DSL.noCondition()) { acc, x ->
            acc.and(x.condition())
        }
        return WhereQuery(condition)
    }
}