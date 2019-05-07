package com.vytenis.transfer.converters;

import com.vytenis.transfer.dto.Account;
import com.vytenis.transfer.dto.Payment;
import com.vytenis.transfer.entity.AccountEntity;
import com.vytenis.transfer.entity.PaymentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentConverter implements EntityConverter<PaymentEntity, Payment> {

    @Autowired
    private AccountConverter accountConverter;

    @Override
    public PaymentEntity convertToEntity(Payment object) {
        if (object == null) {
            return null;
        }

        PaymentEntity entity = new PaymentEntity();
        entity.setId(object.getId());
        entity.setBeneficiary(computeIfNonNull(object.getBeneficiary(), accountConverter::convertToEntity));
        entity.setDebtor(computeIfNonNull(object.getDebtor(), accountConverter::convertToEntity));
        entity.setSum(object.getSum());
        entity.setCurrency(object.getCurrency());
        entity.setStatus(object.getStatus());
        entity.setDate(object.getDate());
        return entity;
    }

    @Override
    public Payment convertFromEntity(PaymentEntity entity) {
        if (entity == null) {
            return null;
        }

        Payment payment = new Payment();
        payment.setId(entity.getId());
        payment.setBeneficiary(computeIfNonNull(entity.getBeneficiary(), this::convertFromEntityLimitedData));
        payment.setDebtor(computeIfNonNull(entity.getDebtor(), this::convertFromEntityLimitedData));
        payment.setSum(entity.getSum());
        payment.setCurrency(entity.getCurrency());
        payment.setStatus(entity.getStatus());
        payment.setDate(entity.getDate());
        return payment;
    }

    private Account convertFromEntityLimitedData(AccountEntity accountEntity) {
        Account account = accountConverter.convertFromEntity(accountEntity);
        account.setUser(null);
        account.setStatus(null);
        account.setBalance(null);
        account.setId(null);
        return account;
    }
}
