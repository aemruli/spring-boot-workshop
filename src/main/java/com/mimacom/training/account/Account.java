package com.mimacom.training.account;

import java.math.BigDecimal;

/**
 * @author Agim Emruli
 */
public class Account {

    private final String id;
    private BigDecimal balance = BigDecimal.ZERO;

    public Account(String id, BigDecimal balance) {
        this.id = id;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void debit(BigDecimal amount) {
        this.balance = this.balance.subtract(amount);
    }


    public void credit(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }
}