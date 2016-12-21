package com.mimacom.training.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author Agim Emruli
 */
@Component
public class AccountWealthContributor implements InfoContributor {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AccountWealthContributor(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("wealth", this.jdbcTemplate.queryForObject("SELECT SUM(BALANCE) FROM ACCOUNT", BigDecimal.class).toPlainString());
    }
}
