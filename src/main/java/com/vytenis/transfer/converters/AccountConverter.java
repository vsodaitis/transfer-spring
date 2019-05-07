package com.vytenis.transfer.converters;

import com.vytenis.transfer.dto.Account;
import com.vytenis.transfer.entity.AccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountConverter implements EntityConverter<AccountEntity, Account> {

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private BalanceConverter balanceConverter;

    @Override
    public AccountEntity convertToEntity(Account object) {
        if (object == null) {
            return null;
        }

        AccountEntity entity = new AccountEntity();
        entity.setId(object.getId());
        entity.setBalance(balanceConverter.convertToEntity(object.getBalance()));
        entity.setCurrency(object.getCurrency());
        entity.setIban(object.getIban());
        entity.setStatus(object.getStatus());
        entity.setUser(userConverter.convertToEntity(object.getUser()));
        return entity;
    }

    @Override
    public Account convertFromEntity(AccountEntity entity) {
        if (entity == null) {
            return null;
        }

        Account account = new Account();
        account.setId(entity.getId());
        account.setBalance(balanceConverter.convertFromEntity(entity.getBalance()));
        account.setCurrency(entity.getCurrency());
        account.setIban(entity.getIban());
        account.setStatus(entity.getStatus());
        account.setUser(userConverter.convertFromEntity(entity.getUser()));
        return account;
    }
}
