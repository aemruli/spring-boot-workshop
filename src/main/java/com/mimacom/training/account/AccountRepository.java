package com.mimacom.training.account;

/**
 * @author Agim Emruli
 */
public interface AccountRepository {

    Account getById(String id);

    void update(Account account);

}
