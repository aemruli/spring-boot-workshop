package com.mimacom.training.web;

import com.mimacom.training.TransferConfirmation;
import com.mimacom.training.TransferRequest;
import com.mimacom.training.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Agim Emruli
 */
@RestController
public class TransferController {

    private final TransferService transferService;

    @Autowired
    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("transfer")
    @ResponseStatus(HttpStatus.CREATED)
    public TransferConfirmation transfer(@RequestBody TransferRequest transferRequest) {
        return this.transferService.transfer(transferRequest);
    }
}