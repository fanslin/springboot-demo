package cn.fanslin.service;

import cn.fanslin.entity.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fanslin on 16/12/1.
 */
@Service
public class EntriesService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void createEntries(String title,String text) {
        this.jdbcTemplate.update("insert into entries(title, text) values(?,?)", title, text);
    }

    public List<Entry> queryEntry(){
        List<Entry> entries = this.jdbcTemplate.query("select title, text from entries",
                (rs, i) -> new Entry(rs.getString("title"), rs.getString("text")));
        return entries;
    }
}
