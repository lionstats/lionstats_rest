package io.github.lionstats.db.postgresql.dao

import io.github.lionstats.db.dao.DAO
import io.github.lionstats.db.dao.DAOPojo
import io.github.lionstats.db.postgresql.tables.ApplicationUser
import io.github.lionstats.db.postgresql.tables.records.ApplicationUserRecord
import org.jooq.*
import java.time.LocalDateTime

data class ApplicationUserPojo(var id: Long? = null,
                               var email: String? = null,
                               var username: String,
                               var password: String,
                               var createdAt: LocalDateTime? = null,
                               var updatedAt: LocalDateTime? = null,
                               var lastLoggedIn: LocalDateTime? = null
): DAOPojo<Long> {
    override fun primaryKeyValue(): Long? = this.id
    override fun primaryKeyField(): Field<Long>? {
        return ApplicationUser.APPLICATION_USER.ID
    }
}
class ApplicationUserDAO(override val dslContext: DSLContext) : DAO<ApplicationUserRecord, ApplicationUserPojo, Long> {
    override fun getTable(): Table<ApplicationUserRecord> {
        return ApplicationUser.APPLICATION_USER
    }

    override fun getPojoClass(): Class<ApplicationUserPojo> {
        return ApplicationUserPojo::class.java
    }

}