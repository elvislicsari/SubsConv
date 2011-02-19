package com.subsconvertor.dao.api;

import org.springframework.jdbc.core.RowMapper;

/**
 * User: cristian.popovici
 */
public abstract class Query<T> extends PreparedStatementAware {

    public abstract RowMapper<T> getRowMapper();

}
