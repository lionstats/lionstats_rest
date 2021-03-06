/*
 * This file is generated by jOOQ.
 */
package io.github.lionstats.db.postgresql.tables.records;


import io.github.lionstats.db.postgresql.tables.GuildWarsApiKey;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class GuildWarsApiKeyRecord extends UpdatableRecordImpl<GuildWarsApiKeyRecord> implements Record7<Long, Long, String, String, LocalDateTime, LocalDateTime, LocalDateTime> {

    private static final long serialVersionUID = 1255957609;

    /**
     * Setter for <code>public.guild_wars_api_key.id</code>.
     */
    public GuildWarsApiKeyRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.guild_wars_api_key.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.guild_wars_api_key.application_user_id</code>.
     */
    public GuildWarsApiKeyRecord setApplicationUserId(Long value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.guild_wars_api_key.application_user_id</code>.
     */
    public Long getApplicationUserId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.guild_wars_api_key.api_key</code>.
     */
    public GuildWarsApiKeyRecord setApiKey(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.guild_wars_api_key.api_key</code>.
     */
    public String getApiKey() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.guild_wars_api_key.name</code>.
     */
    public GuildWarsApiKeyRecord setName(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.guild_wars_api_key.name</code>.
     */
    public String getName() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.guild_wars_api_key.created_at</code>.
     */
    public GuildWarsApiKeyRecord setCreatedAt(LocalDateTime value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.guild_wars_api_key.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(4);
    }

    /**
     * Setter for <code>public.guild_wars_api_key.updated_at</code>.
     */
    public GuildWarsApiKeyRecord setUpdatedAt(LocalDateTime value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.guild_wars_api_key.updated_at</code>.
     */
    public LocalDateTime getUpdatedAt() {
        return (LocalDateTime) get(5);
    }

    /**
     * Setter for <code>public.guild_wars_api_key.last_used</code>.
     */
    public GuildWarsApiKeyRecord setLastUsed(LocalDateTime value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>public.guild_wars_api_key.last_used</code>.
     */
    public LocalDateTime getLastUsed() {
        return (LocalDateTime) get(6);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row7<Long, Long, String, String, LocalDateTime, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    @Override
    public Row7<Long, Long, String, String, LocalDateTime, LocalDateTime, LocalDateTime> valuesRow() {
        return (Row7) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return GuildWarsApiKey.GUILD_WARS_API_KEY.ID;
    }

    @Override
    public Field<Long> field2() {
        return GuildWarsApiKey.GUILD_WARS_API_KEY.APPLICATION_USER_ID;
    }

    @Override
    public Field<String> field3() {
        return GuildWarsApiKey.GUILD_WARS_API_KEY.API_KEY;
    }

    @Override
    public Field<String> field4() {
        return GuildWarsApiKey.GUILD_WARS_API_KEY.NAME;
    }

    @Override
    public Field<LocalDateTime> field5() {
        return GuildWarsApiKey.GUILD_WARS_API_KEY.CREATED_AT;
    }

    @Override
    public Field<LocalDateTime> field6() {
        return GuildWarsApiKey.GUILD_WARS_API_KEY.UPDATED_AT;
    }

    @Override
    public Field<LocalDateTime> field7() {
        return GuildWarsApiKey.GUILD_WARS_API_KEY.LAST_USED;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public Long component2() {
        return getApplicationUserId();
    }

    @Override
    public String component3() {
        return getApiKey();
    }

    @Override
    public String component4() {
        return getName();
    }

    @Override
    public LocalDateTime component5() {
        return getCreatedAt();
    }

    @Override
    public LocalDateTime component6() {
        return getUpdatedAt();
    }

    @Override
    public LocalDateTime component7() {
        return getLastUsed();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public Long value2() {
        return getApplicationUserId();
    }

    @Override
    public String value3() {
        return getApiKey();
    }

    @Override
    public String value4() {
        return getName();
    }

    @Override
    public LocalDateTime value5() {
        return getCreatedAt();
    }

    @Override
    public LocalDateTime value6() {
        return getUpdatedAt();
    }

    @Override
    public LocalDateTime value7() {
        return getLastUsed();
    }

    @Override
    public GuildWarsApiKeyRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public GuildWarsApiKeyRecord value2(Long value) {
        setApplicationUserId(value);
        return this;
    }

    @Override
    public GuildWarsApiKeyRecord value3(String value) {
        setApiKey(value);
        return this;
    }

    @Override
    public GuildWarsApiKeyRecord value4(String value) {
        setName(value);
        return this;
    }

    @Override
    public GuildWarsApiKeyRecord value5(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public GuildWarsApiKeyRecord value6(LocalDateTime value) {
        setUpdatedAt(value);
        return this;
    }

    @Override
    public GuildWarsApiKeyRecord value7(LocalDateTime value) {
        setLastUsed(value);
        return this;
    }

    @Override
    public GuildWarsApiKeyRecord values(Long value1, Long value2, String value3, String value4, LocalDateTime value5, LocalDateTime value6, LocalDateTime value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached GuildWarsApiKeyRecord
     */
    public GuildWarsApiKeyRecord() {
        super(GuildWarsApiKey.GUILD_WARS_API_KEY);
    }

    /**
     * Create a detached, initialised GuildWarsApiKeyRecord
     */
    public GuildWarsApiKeyRecord(Long id, Long applicationUserId, String apiKey, String name, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime lastUsed) {
        super(GuildWarsApiKey.GUILD_WARS_API_KEY);

        set(0, id);
        set(1, applicationUserId);
        set(2, apiKey);
        set(3, name);
        set(4, createdAt);
        set(5, updatedAt);
        set(6, lastUsed);
    }
}
