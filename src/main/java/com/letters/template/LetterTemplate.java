package com.letters.template;

import com.letters.dao.LetterDAO;
import com.letters.mapper.LetterMapper;
import com.letters.models.Letter;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Mandeep Raj Shrestha
 */
public class LetterTemplate implements LetterDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public void create() {
    }

    @Override
    public void insert(Letter letter) {
        String SQL = "insert into letter(`to`, `from`, `subject`, `body`) values(?, ?, ?, ?)";
        jdbcTemplateObject.update(SQL, letter.getTo(), letter.getFrom(), letter.getSubject(), letter.getBody());
    }

    @Override
    public List<Letter> list() {
        String SQL = "select `id`,`to`, `from`, `subject`, body from letter";
        List<Letter> letter = jdbcTemplateObject.query(SQL, new LetterMapper());
        return letter;
    }

    @Override
    public Letter get(int id) {
        String SQL = "select * from letter where id = ?";
        Letter letter = jdbcTemplateObject.queryForObject(SQL,
                new Object[]{id}, new LetterMapper());
        return letter;
    }

    @Override
    public void update(Letter letter) {
        String SQL = "update letter set `to` = ?, `from`=?, `subject`=?, `body`=? where `id` = ?";
        jdbcTemplateObject.update(SQL, letter.getTo(), letter.getFrom(), letter.getSubject(), letter.getBody(),letter.getId());
    }

    @Override
    public void delete(int id) {
        String SQL = "delete from letter where `id` = ?";
        jdbcTemplateObject.update(SQL, id);
    }

}
