package com.mimacom.training;

/**
 * @author Agim Emruli
 */
public interface TransferService {

    TransferConfirmation transfer(TransferRequest transferRequest);
}
