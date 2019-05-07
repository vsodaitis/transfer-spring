package com.vytenis.transfer.service;

import com.vytenis.transfer.dao.BalanceDao;
import com.vytenis.transfer.dto.Balance;
import com.vytenis.transfer.entity.BalanceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.NoSuchElementException;

@Service
public class BalanceService {

    @Autowired
    private BalanceDao balanceDao;

    @Transactional
    public void add(Balance balance, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Can not add negative sum");
        }

        BalanceEntity balanceEntity = balanceDao.findById(balance.getId()).orElseThrow(NoSuchElementException::new);
        balanceEntity.setTotal(balanceEntity.getTotal().add(amount));
    }

    @Transactional
    public void subtract(Balance balance, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Can not subtract negative sum");
        }

        BalanceEntity balanceEntity = balanceDao.findById(balance.getId()).orElseThrow(NoSuchElementException::new);
        if (amount.compareTo(balanceEntity.getAvailable()) > 0) {
            throw new IllegalArgumentException("Not enough available funds");
        }

        balanceEntity.setTotal(balanceEntity.getTotal().subtract(amount));
    }
}
