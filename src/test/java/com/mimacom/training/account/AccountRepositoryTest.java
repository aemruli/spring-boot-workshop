package com.mimacom.training.account;

import com.mimacom.training.TransferServiceApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * @author Agim Emruli
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TransferServiceApplication.class)
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    @Transactional
    public void getById_forExistingAccount_returnsAccountWithCorrectIdAndBalance() throws Exception {
        //Arrange

        //Act
        Account account = accountRepository.getById("1");

        //Assert
        assertEquals("1", account.getId());
        assertEquals(BigDecimal.ONE, account.getBalance());
    }

    @Test
    public void update_forExistingAccountWithDifferentBalanceThenDatabase_updatesBalanceAndBalanceAvailableOnDatabase() throws Exception {
        //Arrange
        Account account = accountRepository.getById("1");
        account.credit(new BigDecimal(100));

        //Act
        accountRepository.update(account);

        //Assert
        Account updatedAccount = accountRepository.getById("1");
        assertEquals(new BigDecimal(101), updatedAccount.getBalance());
    }
}
