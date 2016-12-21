package com.mimacom.training.account.internal;

import com.mimacom.training.account.Account;
import com.mimacom.training.account.AccountRepository;

/**
 * @author Agim Emruli
 */
//TODO: Configure class as @Repository
public class JdbcAccountRepository implements AccountRepository {


    @Override
    public Account getById(String id) {
        //TODO: Implement select with RowMapper using JdbcTemplate
        return null;
    }

    @Override
    public void update(Account account) {
        //TODO: Implement update
    }
}