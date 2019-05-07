package com.vytenis.transfer.service;

import com.vytenis.transfer.converters.AccountConverter;
import com.vytenis.transfer.converters.UserConverter;
import com.vytenis.transfer.dao.AccountDao;
import com.vytenis.transfer.dao.BalanceDao;
import com.vytenis.transfer.dto.Account;
import com.vytenis.transfer.dto.User;
import com.vytenis.transfer.entity.AccountEntity;
import com.vytenis.transfer.entity.BalanceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountService {

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private AccountConverter accountConverter;

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private BalanceDao balanceDao;

    public List<Account> getUserAccounts(User user) {
        return accountDao.findByUser(userConverter.convertToEntity(user)).stream()
                .map(accountConverter::convertFromEntity)
                .collect(Collectors.toList());
    }

    @Transactional
    public long addUserAccount(Account account) {
        AccountEntity accountEntity = accountConverter.convertToEntity(account);
        BalanceEntity balanceEntity = accountEntity.getBalance();
        balanceDao.save(balanceEntity);
        accountDao.save(accountEntity);
        return accountEntity.getId();
    }

    public Optional<Account> findByIban(String iban) {
        try {
            return Optional.of(accountConverter.convertFromEntity(accountDao.findByIban(iban)));
        } catch (NoResultException | NonUniqueResultException e) {
            return Optional.empty();
        }
    }
}
