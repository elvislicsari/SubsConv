package com.subsconvertor.dao.api;

import org.springframework.jdbc.support.KeyHolder;

/**
 *
 */
public abstract class Insert extends PreparedStatementAware {

    public abstract KeyHolder getKeyHolder();
}
