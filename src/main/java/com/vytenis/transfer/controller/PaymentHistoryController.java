package com.vytenis.transfer.controller;

import com.vytenis.transfer.dto.Account;
import com.vytenis.transfer.dto.Payment;
import com.vytenis.transfer.service.PaymentHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/history", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PaymentHistoryController {

    @Autowired
    private PaymentHistoryService paymentHistoryService;

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentHistoryService.getAllPayments();
    }

    @PostMapping("/beneficiary")
    public List<Payment> getByBeneficiary(Account account) {
        return paymentHistoryService.getByBeneficiary(account);
    }

    @PostMapping("/debtor")
    public List<Payment> getByDebtor(Account account) {
        return paymentHistoryService.getByDebtor(account);
    }
}
