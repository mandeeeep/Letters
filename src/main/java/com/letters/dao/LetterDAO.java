package com.letters.dao;

import com.letters.models.Letter;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author Mandeep Raj Shrestha
 */
public interface LetterDAO {

    public void setDataSource(DataSource ds);

    public void create();

    public void insert(Letter letter);

    public List<Letter> list();

    public Letter get(int id);

    public void update(Letter letter);

    public void delete(int id);

}
