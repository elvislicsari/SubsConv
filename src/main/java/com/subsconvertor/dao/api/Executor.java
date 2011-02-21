package com.subsconvertor.dao.api;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.util.List;

public abstract class Executor<T> {

    private final JdbcTemplate template;

    protected Executor(final DataSource dataSource) {
        if (dataSource == null) {
            throw new IllegalArgumentException("Data source is null");
        }
        this.template = new JdbcTemplate(dataSource);
    }

    public List<T> executeQuery(final Query<T> command) {
        return template.query(command.prepareStatement(), command.getRowMapper());
    }

    public T executeFind(final Find<T> command) {
        return template.query(command.prepareStatement(), command.getResultSetExtractor());
    }

    public void executeUpdate(final Update command) {
        template.update(command.prepareStatement());
    }

    public long executeUpdate(final Insert command) {
        KeyHolder keyHolder = command.getKeyHolder();
        template.update(command.prepareStatement(), keyHolder);
        return keyHolder.getKey().longValue();
    }
}
