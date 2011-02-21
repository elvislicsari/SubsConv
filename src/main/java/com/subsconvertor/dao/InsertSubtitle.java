package com.subsconvertor.dao;

import com.subsconvertor.dao.api.Insert;
import com.subsconvertor.model.Subtitle;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 */
public class InsertSubtitle extends Insert {

    private static String query = "INSERT INTO `subtitles` (`subtitleName`,`subtitleContentType`,`subtitleOriginalContent`,`subtitleConvertedContent`,`framerateFrom`,`framerateInto`, `subtitleType`, `language`) VALUES (?,?,?,?,?,?,?,?)";

    private Subtitle sub;

    public InsertSubtitle(Subtitle sub) {
        this.sub = sub;
    }

    @Override
    protected PreparedStatement getPreparedStatement(Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        ps.setString(1, sub.getSubtitleName());
        ps.setString(2, sub.getSubtitleContentType());
        ps.setBytes(3, sub.getSubtitleOriginalContent());
        ps.setBytes(4, sub.getSubtitleConvertedContent());
        ps.setFloat(5, sub.getFramerateFrom());
        ps.setFloat(6, sub.getFramerateInto());
        ps.setString(7, sub.getSubtitleType());
        ps.setString(8, sub.getLanguage());
        return ps;
    }

    @Override
    public KeyHolder getKeyHolder() {
        return new GeneratedKeyHolder();
    }
}
