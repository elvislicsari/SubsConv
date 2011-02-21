package com.subsconvertor.dao;

import com.subsconvertor.dao.api.Executor;
import com.subsconvertor.model.Subtitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@Repository(value = "subtitleDao")
public class SubtitleDao extends Executor<Subtitle> {

    @Autowired
    public SubtitleDao(final DataSource dataSource) {
        super(dataSource);
    }

    @Transactional
    public long saveSubtitle(Subtitle sub) {
        InsertSubtitle insert = new InsertSubtitle(sub);
        return executeUpdate(insert);
    }
}
