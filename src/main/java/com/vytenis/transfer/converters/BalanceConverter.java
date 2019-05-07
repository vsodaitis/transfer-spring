package com.vytenis.transfer.converters;

import com.vytenis.transfer.dto.Balance;
import com.vytenis.transfer.entity.BalanceEntity;
import org.springframework.stereotype.Component;

@Component
public class BalanceConverter implements EntityConverter<BalanceEntity, Balance> {

    @Override
    public BalanceEntity convertToEntity(Balance object) {
        if (object == null) {
            return null;
        }

        BalanceEntity balanceEntity = new BalanceEntity();
        balanceEntity.setId(object.getId());
        balanceEntity.setReserved(object.getReserved());
        balanceEntity.setTotal(object.getTotal());
        return balanceEntity;
    }

    @Override
    public Balance convertFromEntity(BalanceEntity entity) {
        if (entity == null) {
            return null;
        }

        Balance balance = new Balance();
        balance.setId(entity.getId());
        balance.setReserved(entity.getReserved());
        balance.setTotal(entity.getTotal());
        return balance;
    }
}
