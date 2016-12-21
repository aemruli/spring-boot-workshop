package com.mimacom.training.account.internal;

import com.mimacom.training.account.Account;
import com.mimacom.training.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author Agim Emruli
 */
@Repository
public class JdbcAccountRepository implements AccountRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcAccountRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Account getById(String id) {
        return jdbcTemplate.queryForObject("SELECT * FROM ACCOUNT WHERE ID = ?", (resultSet, i) -> new Account(resultSet.getString("id"), resultSet.getBigDecimal("balance")), id);
    }

    @Override
    public void update(Account account) {
        jdbcTemplate.update("UPDATE ACCOUNT SET BALANCE=? WHERE ID=?", account.getBalance(), account.getId());
    }
}