/*
 * This file is generated by jOOQ.
 */
package io.github.lionstats.db.postgresql;


import io.github.lionstats.db.postgresql.tables.ApplicationUser;
import io.github.lionstats.db.postgresql.tables.FlywaySchemaHistory;
import io.github.lionstats.db.postgresql.tables.GuildWarsApiKey;
import io.github.lionstats.db.postgresql.tables.records.ApplicationUserRecord;
import io.github.lionstats.db.postgresql.tables.records.FlywaySchemaHistoryRecord;
import io.github.lionstats.db.postgresql.tables.records.GuildWarsApiKeyRecord;

import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>public</code> schema.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<ApplicationUserRecord, Long> IDENTITY_APPLICATION_USER = Identities0.IDENTITY_APPLICATION_USER;
    public static final Identity<GuildWarsApiKeyRecord, Long> IDENTITY_GUILD_WARS_API_KEY = Identities0.IDENTITY_GUILD_WARS_API_KEY;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<ApplicationUserRecord> APPLICATION_USER_PKEY = UniqueKeys0.APPLICATION_USER_PKEY;
    public static final UniqueKey<FlywaySchemaHistoryRecord> FLYWAY_SCHEMA_HISTORY_PK = UniqueKeys0.FLYWAY_SCHEMA_HISTORY_PK;
    public static final UniqueKey<GuildWarsApiKeyRecord> GUILD_WARS_API_KEY_PKEY = UniqueKeys0.GUILD_WARS_API_KEY_PKEY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<GuildWarsApiKeyRecord, ApplicationUserRecord> GUILD_WARS_API_KEY__GUILD_WARS_API_KEY_APPLICATION_USER_ID_FKEY = ForeignKeys0.GUILD_WARS_API_KEY__GUILD_WARS_API_KEY_APPLICATION_USER_ID_FKEY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<ApplicationUserRecord, Long> IDENTITY_APPLICATION_USER = Internal.createIdentity(ApplicationUser.APPLICATION_USER, ApplicationUser.APPLICATION_USER.ID);
        public static Identity<GuildWarsApiKeyRecord, Long> IDENTITY_GUILD_WARS_API_KEY = Internal.createIdentity(GuildWarsApiKey.GUILD_WARS_API_KEY, GuildWarsApiKey.GUILD_WARS_API_KEY.ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<ApplicationUserRecord> APPLICATION_USER_PKEY = Internal.createUniqueKey(ApplicationUser.APPLICATION_USER, "application_user_pkey", new TableField[] { ApplicationUser.APPLICATION_USER.ID }, true);
        public static final UniqueKey<FlywaySchemaHistoryRecord> FLYWAY_SCHEMA_HISTORY_PK = Internal.createUniqueKey(FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY, "flyway_schema_history_pk", new TableField[] { FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.INSTALLED_RANK }, true);
        public static final UniqueKey<GuildWarsApiKeyRecord> GUILD_WARS_API_KEY_PKEY = Internal.createUniqueKey(GuildWarsApiKey.GUILD_WARS_API_KEY, "guild_wars_api_key_pkey", new TableField[] { GuildWarsApiKey.GUILD_WARS_API_KEY.ID }, true);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<GuildWarsApiKeyRecord, ApplicationUserRecord> GUILD_WARS_API_KEY__GUILD_WARS_API_KEY_APPLICATION_USER_ID_FKEY = Internal.createForeignKey(Keys.APPLICATION_USER_PKEY, GuildWarsApiKey.GUILD_WARS_API_KEY, "guild_wars_api_key_application_user_id_fkey", new TableField[] { GuildWarsApiKey.GUILD_WARS_API_KEY.APPLICATION_USER_ID }, true);
    }
}
