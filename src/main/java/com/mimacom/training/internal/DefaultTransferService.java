package com.mimacom.training.internal;

import com.mimacom.training.TransferConfirmation;
import com.mimacom.training.TransferRequest;
import com.mimacom.training.TransferService;

/**
 * @author Agim Emruli
 */
//TODO: Mark Class as @Service
public class DefaultTransferService implements TransferService {


    @Override
    public TransferConfirmation transfer(TransferRequest transferRequest) {
        //TODO: Implement business logic using account.debit and account credit, store accounts after transaction
        return null;
    }
}
