package com.mimacom.training.web;

import com.mimacom.training.TransferConfirmation;
import com.mimacom.training.TransferRequest;
import com.mimacom.training.TransferServiceApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Agim Emruli
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TransferServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TransferControllerTest {

    @Autowired
    private SecurityProperties securityProperties;

    @LocalServerPort
    private String port;

    private TestRestTemplate restTemplate;

    @Before
    public void configureAuthentication() throws Exception {
        restTemplate = new TestRestTemplate(securityProperties.getUser().getName(),
                securityProperties.getUser().getPassword());

    }

    @Test
    public void transfer_withValidTransferRequest_transferMoneyAndReturnsNewBalance() throws Exception {
        //Arrange
        TransferRequest request = new TransferRequest("2", "1", new BigDecimal(50));

        //Act
        ResponseEntity<TransferConfirmation> transferConfirmationResponseEntity = restTemplate.postForEntity("http://localhost:{port}/transfer", request, TransferConfirmation.class, port);

        //Assert
        assertEquals(HttpStatus.CREATED, transferConfirmationResponseEntity.getStatusCode());
        assertNotNull(transferConfirmationResponseEntity.getBody().getId());
        assertEquals(new BigDecimal(51), transferConfirmationResponseEntity.getBody().getNewBalance());
    }
}
