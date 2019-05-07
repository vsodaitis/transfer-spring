package com.vytenis.transfer.dao;

import com.vytenis.transfer.entity.BalanceEntity;
import org.springframework.data.repository.CrudRepository;

public interface BalanceDao extends CrudRepository<BalanceEntity, Long> {
}
