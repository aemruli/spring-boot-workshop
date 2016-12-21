package com.mimacom.training.internal;

import com.mimacom.training.TransferConfirmation;
import com.mimacom.training.TransferRequest;
import com.mimacom.training.TransferService;
import com.mimacom.training.account.Account;
import com.mimacom.training.account.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author Agim Emruli
 */
@Service
public class DefaultTransferService implements TransferService {

    private final AccountRepository accountRepository;

    public DefaultTransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public TransferConfirmation transfer(TransferRequest transferRequest) {
        Account source = this.accountRepository.getById(transferRequest.getSourceId());
        Account target = this.accountRepository.getById(transferRequest.getTargetId());

        source.debit(transferRequest.getAmount());
        target.credit(transferRequest.getAmount());

        this.accountRepository.update(source);
        this.accountRepository.update(target);

        return new TransferConfirmation(UUID.randomUUID().toString(), target.getBalance());
    }
}
