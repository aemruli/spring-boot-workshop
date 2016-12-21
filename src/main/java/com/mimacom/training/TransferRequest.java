package com.mimacom.training;

import java.math.BigDecimal;

public class TransferRequest {
    private String sourceId;
    private String targetId;
    private BigDecimal amount;


    public TransferRequest() {
    }

    public TransferRequest(String sourceId, String targetId, BigDecimal amount) {
        this.sourceId = sourceId;
        this.targetId = targetId;
        this.amount = amount;
    }

    public String getSourceId() {
        return sourceId;
    }

    public String getTargetId() {
        return targetId;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
