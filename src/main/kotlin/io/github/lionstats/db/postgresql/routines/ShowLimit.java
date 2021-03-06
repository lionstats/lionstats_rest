/*
 * This file is generated by jOOQ.
 */
package io.github.lionstats.db.postgresql.routines;


import io.github.lionstats.db.postgresql.Public;

import org.jooq.Parameter;
import org.jooq.impl.AbstractRoutine;
import org.jooq.impl.Internal;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ShowLimit extends AbstractRoutine<Float> {

    private static final long serialVersionUID = 528818793;

    /**
     * The parameter <code>public.show_limit.RETURN_VALUE</code>.
     */
    public static final Parameter<Float> RETURN_VALUE = Internal.createParameter("RETURN_VALUE", org.jooq.impl.SQLDataType.REAL, false, false);

    /**
     * Create a new routine call instance
     */
    public ShowLimit() {
        super("show_limit", Public.PUBLIC, org.jooq.impl.SQLDataType.REAL);

        setReturnParameter(RETURN_VALUE);
    }
}
