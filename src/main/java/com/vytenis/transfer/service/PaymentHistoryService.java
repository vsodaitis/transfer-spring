package com.vytenis.transfer.service;

import com.vytenis.transfer.converters.AccountConverter;
import com.vytenis.transfer.converters.PaymentConverter;
import com.vytenis.transfer.dao.PaymentDao;
import com.vytenis.transfer.dto.Account;
import com.vytenis.transfer.dto.Payment;
import com.vytenis.transfer.entity.PaymentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
public class PaymentHistoryService {

    @Autowired
    private PaymentConverter paymentConverter;

    @Autowired
    private AccountConverter accountConverter;

    @Autowired
    private PaymentDao paymentDao;

    @Transactional
    public Payment addPayment(Payment payment) {
        PaymentEntity paymentEntity = paymentConverter.convertToEntity(payment);
        paymentDao.save(paymentEntity);
        return paymentConverter.convertFromEntity(paymentEntity);
    }

    public List<Payment> getAllPayments() {
        return paymentDao.findAllSortByDate().stream()
                .map(paymentConverter::convertFromEntity)
                .collect(Collectors.toList());
    }

    public List<Payment> getByBeneficiary(Account beneficiary) {
        return convert(() -> paymentDao.findAllByBeneficiary(accountConverter.convertToEntity(beneficiary)));
    }

    public List<Payment> getByDebtor(Account debtor) {
        return convert(() -> paymentDao.findAllByDebtor(accountConverter.convertToEntity(debtor)));
    }

    private List<Payment> convert(Supplier<List<PaymentEntity>> supplier) {
        return supplier.get().stream()
                .map(paymentConverter::convertFromEntity)
                .collect(Collectors.toList());
    }
}
