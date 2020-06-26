/*
 * This file is generated by jOOQ.
 */
package io.github.lionstats.db.postgresql;


import org.jooq.Sequence;
import org.jooq.impl.Internal;


/**
 * Convenience access to all sequences in public
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sequences {

    /**
     * The sequence <code>public.application_user_id_seq</code>
     */
    public static final Sequence<Long> APPLICATION_USER_ID_SEQ = Internal.createSequence("application_user_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.guild_wars_api_key_id_seq</code>
     */
    public static final Sequence<Long> GUILD_WARS_API_KEY_ID_SEQ = Internal.createSequence("guild_wars_api_key_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);
}