package com.letters.mapper;

import com.letters.models.Letter;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Mandeep Raj Shrestha
 */
public class LetterMapper implements RowMapper<Letter> {

    @Override
    public Letter mapRow(ResultSet rs, int rowNum) throws SQLException {
        Letter l = new Letter();
        l.setId(rs.getInt("id"));
        l.setTo(rs.getString("to"));
        l.setFrom(rs.getString("from"));
        l.setSubject(rs.getString("subject"));
        l.setBody(rs.getString("body"));
        return l;
    }

}
