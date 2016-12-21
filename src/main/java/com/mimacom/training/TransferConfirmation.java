package com.mimacom.training;

import java.math.BigDecimal;

/**
 * @author Agim Emruli
 */
public class TransferConfirmation {

    private String id;
    private BigDecimal newBalance;

    protected TransferConfirmation(){
    }

    public TransferConfirmation(String id, BigDecimal newBalance) {
        this.id = id;
        this.newBalance = newBalance;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getNewBalance() {
        return newBalance;
    }
}
