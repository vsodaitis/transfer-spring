package com.vytenis.transfer.controller;

import com.vytenis.transfer.dto.Payment;
import com.vytenis.transfer.dto.TransferRequest;
import com.vytenis.transfer.service.MoneyTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/transfer", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MoneyTransferController {

    @Autowired
    private MoneyTransferService moneyTransferService;

    @PostMapping("/topup")
    public Payment topUp(TransferRequest transferRequest) {
        return moneyTransferService.topUp(
                transferRequest.getBeneficiary(),
                transferRequest.getSum(),
                transferRequest.getCurrency());
    }

    @PostMapping
    public Payment transfer(TransferRequest transferRequest) {
        return moneyTransferService.transfer(
                transferRequest.getDebtor(),
                transferRequest.getBeneficiary(),
                transferRequest.getSum(),
                transferRequest.getCurrency());
    }
}
