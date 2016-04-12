package com.yo1000.insecure.repository.jdbc;

import com.yo1000.insecure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class JdbcUserRepository implements UserRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, Object>> select() {
        return getJdbcTemplate().queryForList("SELECT username, password, fullname FROM user");
    }

    public Map<String, Object> select(String username, String password) {
        List<Map<String, Object>> users = getJdbcTemplate().queryForList("SELECT " +
                "username, password, fullname " +
                "FROM user " +
                "WHERE username='" + username + "' " +
                "AND   password='" + password + "'");
        return users.isEmpty() ? null : users.get(0);
    }

    public Map<String, Object> update(String username, String password, String fullname) {
        getJdbcTemplate().update("UPDATE user SET " +
                "fullname='" + fullname + "' " +
                "WHERE username = '" + username + "'");

        return select(username, password);
    }

    protected JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}
