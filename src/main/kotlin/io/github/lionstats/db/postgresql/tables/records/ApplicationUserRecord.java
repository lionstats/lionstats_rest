/*
 * This file is generated by jOOQ.
 */
package io.github.lionstats.db.postgresql.tables.records;


import io.github.lionstats.db.postgresql.tables.ApplicationUser;

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
public class ApplicationUserRecord extends UpdatableRecordImpl<ApplicationUserRecord> implements Record7<Long, String, String, byte[], LocalDateTime, LocalDateTime, LocalDateTime> {

    private static final long serialVersionUID = 111717013;

    /**
     * Setter for <code>public.application_user.id</code>.
     */
    public ApplicationUserRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.application_user.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.application_user.email</code>.
     */
    public ApplicationUserRecord setEmail(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.application_user.email</code>.
     */
    public String getEmail() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.application_user.username</code>.
     */
    public ApplicationUserRecord setUsername(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.application_user.username</code>.
     */
    public String getUsername() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.application_user.password</code>.
     */
    public ApplicationUserRecord setPassword(byte[] value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.application_user.password</code>.
     */
    public byte[] getPassword() {
        return (byte[]) get(3);
    }

    /**
     * Setter for <code>public.application_user.created_at</code>.
     */
    public ApplicationUserRecord setCreatedAt(LocalDateTime value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.application_user.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(4);
    }

    /**
     * Setter for <code>public.application_user.updated_at</code>.
     */
    public ApplicationUserRecord setUpdatedAt(LocalDateTime value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.application_user.updated_at</code>.
     */
    public LocalDateTime getUpdatedAt() {
        return (LocalDateTime) get(5);
    }

    /**
     * Setter for <code>public.application_user.last_logged_in</code>.
     */
    public ApplicationUserRecord setLastLoggedIn(LocalDateTime value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>public.application_user.last_logged_in</code>.
     */
    public LocalDateTime getLastLoggedIn() {
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
    public Row7<Long, String, String, byte[], LocalDateTime, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    @Override
    public Row7<Long, String, String, byte[], LocalDateTime, LocalDateTime, LocalDateTime> valuesRow() {
        return (Row7) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return ApplicationUser.APPLICATION_USER.ID;
    }

    @Override
    public Field<String> field2() {
        return ApplicationUser.APPLICATION_USER.EMAIL;
    }

    @Override
    public Field<String> field3() {
        return ApplicationUser.APPLICATION_USER.USERNAME;
    }

    @Override
    public Field<byte[]> field4() {
        return ApplicationUser.APPLICATION_USER.PASSWORD;
    }

    @Override
    public Field<LocalDateTime> field5() {
        return ApplicationUser.APPLICATION_USER.CREATED_AT;
    }

    @Override
    public Field<LocalDateTime> field6() {
        return ApplicationUser.APPLICATION_USER.UPDATED_AT;
    }

    @Override
    public Field<LocalDateTime> field7() {
        return ApplicationUser.APPLICATION_USER.LAST_LOGGED_IN;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getEmail();
    }

    @Override
    public String component3() {
        return getUsername();
    }

    @Override
    public byte[] component4() {
        return getPassword();
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
        return getLastLoggedIn();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getEmail();
    }

    @Override
    public String value3() {
        return getUsername();
    }

    @Override
    public byte[] value4() {
        return getPassword();
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
        return getLastLoggedIn();
    }

    @Override
    public ApplicationUserRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public ApplicationUserRecord value2(String value) {
        setEmail(value);
        return this;
    }

    @Override
    public ApplicationUserRecord value3(String value) {
        setUsername(value);
        return this;
    }

    @Override
    public ApplicationUserRecord value4(byte[] value) {
        setPassword(value);
        return this;
    }

    @Override
    public ApplicationUserRecord value5(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public ApplicationUserRecord value6(LocalDateTime value) {
        setUpdatedAt(value);
        return this;
    }

    @Override
    public ApplicationUserRecord value7(LocalDateTime value) {
        setLastLoggedIn(value);
        return this;
    }

    @Override
    public ApplicationUserRecord values(Long value1, String value2, String value3, byte[] value4, LocalDateTime value5, LocalDateTime value6, LocalDateTime value7) {
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
     * Create a detached ApplicationUserRecord
     */
    public ApplicationUserRecord() {
        super(ApplicationUser.APPLICATION_USER);
    }

    /**
     * Create a detached, initialised ApplicationUserRecord
     */
    public ApplicationUserRecord(Long id, String email, String username, byte[] password, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime lastLoggedIn) {
        super(ApplicationUser.APPLICATION_USER);

        set(0, id);
        set(1, email);
        set(2, username);
        set(3, password);
        set(4, createdAt);
        set(5, updatedAt);
        set(6, lastLoggedIn);
    }
}