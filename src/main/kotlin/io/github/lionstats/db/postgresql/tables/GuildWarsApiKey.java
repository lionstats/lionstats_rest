/*
 * This file is generated by jOOQ.
 */
package io.github.lionstats.db.postgresql.tables;


import io.github.lionstats.db.postgresql.Keys;
import io.github.lionstats.db.postgresql.Public;
import io.github.lionstats.db.postgresql.tables.records.GuildWarsApiKeyRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row7;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class GuildWarsApiKey extends TableImpl<GuildWarsApiKeyRecord> {

    private static final long serialVersionUID = 1195486215;

    /**
     * The reference instance of <code>public.guild_wars_api_key</code>
     */
    public static final GuildWarsApiKey GUILD_WARS_API_KEY = new GuildWarsApiKey();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<GuildWarsApiKeyRecord> getRecordType() {
        return GuildWarsApiKeyRecord.class;
    }

    /**
     * The column <code>public.guild_wars_api_key.id</code>.
     */
    public final TableField<GuildWarsApiKeyRecord, Long> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('guild_wars_api_key_id_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.guild_wars_api_key.application_user_id</code>.
     */
    public final TableField<GuildWarsApiKeyRecord, Long> APPLICATION_USER_ID = createField(DSL.name("application_user_id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.guild_wars_api_key.api_key</code>.
     */
    public final TableField<GuildWarsApiKeyRecord, String> API_KEY = createField(DSL.name("api_key"), org.jooq.impl.SQLDataType.VARCHAR(72).nullable(false), this, "");

    /**
     * The column <code>public.guild_wars_api_key.name</code>.
     */
    public final TableField<GuildWarsApiKeyRecord, String> NAME = createField(DSL.name("name"), org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>public.guild_wars_api_key.created_at</code>.
     */
    public final TableField<GuildWarsApiKeyRecord, LocalDateTime> CREATED_AT = createField(DSL.name("created_at"), org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false).defaultValue(org.jooq.impl.DSL.field("now()", org.jooq.impl.SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.guild_wars_api_key.updated_at</code>.
     */
    public final TableField<GuildWarsApiKeyRecord, LocalDateTime> UPDATED_AT = createField(DSL.name("updated_at"), org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false).defaultValue(org.jooq.impl.DSL.field("now()", org.jooq.impl.SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.guild_wars_api_key.last_used</code>.
     */
    public final TableField<GuildWarsApiKeyRecord, LocalDateTime> LAST_USED = createField(DSL.name("last_used"), org.jooq.impl.SQLDataType.LOCALDATETIME, this, "");

    /**
     * Create a <code>public.guild_wars_api_key</code> table reference
     */
    public GuildWarsApiKey() {
        this(DSL.name("guild_wars_api_key"), null);
    }

    /**
     * Create an aliased <code>public.guild_wars_api_key</code> table reference
     */
    public GuildWarsApiKey(String alias) {
        this(DSL.name(alias), GUILD_WARS_API_KEY);
    }

    /**
     * Create an aliased <code>public.guild_wars_api_key</code> table reference
     */
    public GuildWarsApiKey(Name alias) {
        this(alias, GUILD_WARS_API_KEY);
    }

    private GuildWarsApiKey(Name alias, Table<GuildWarsApiKeyRecord> aliased) {
        this(alias, aliased, null);
    }

    private GuildWarsApiKey(Name alias, Table<GuildWarsApiKeyRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> GuildWarsApiKey(Table<O> child, ForeignKey<O, GuildWarsApiKeyRecord> key) {
        super(child, key, GUILD_WARS_API_KEY);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public Identity<GuildWarsApiKeyRecord, Long> getIdentity() {
        return Keys.IDENTITY_GUILD_WARS_API_KEY;
    }

    @Override
    public UniqueKey<GuildWarsApiKeyRecord> getPrimaryKey() {
        return Keys.GUILD_WARS_API_KEY_PKEY;
    }

    @Override
    public List<UniqueKey<GuildWarsApiKeyRecord>> getKeys() {
        return Arrays.<UniqueKey<GuildWarsApiKeyRecord>>asList(Keys.GUILD_WARS_API_KEY_PKEY);
    }

    @Override
    public List<ForeignKey<GuildWarsApiKeyRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<GuildWarsApiKeyRecord, ?>>asList(Keys.GUILD_WARS_API_KEY__GUILD_WARS_API_KEY_APPLICATION_USER_ID_FKEY);
    }

    public ApplicationUser applicationUser() {
        return new ApplicationUser(this, Keys.GUILD_WARS_API_KEY__GUILD_WARS_API_KEY_APPLICATION_USER_ID_FKEY);
    }

    @Override
    public GuildWarsApiKey as(String alias) {
        return new GuildWarsApiKey(DSL.name(alias), this);
    }

    @Override
    public GuildWarsApiKey as(Name alias) {
        return new GuildWarsApiKey(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public GuildWarsApiKey rename(String name) {
        return new GuildWarsApiKey(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public GuildWarsApiKey rename(Name name) {
        return new GuildWarsApiKey(name, null);
    }

    // -------------------------------------------------------------------------
    // Row7 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row7<Long, Long, String, String, LocalDateTime, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row7) super.fieldsRow();
    }
}