package com.vytenis.transfer.dao;

import com.vytenis.transfer.entity.AccountEntity;
import com.vytenis.transfer.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountDao extends CrudRepository<AccountEntity, Long> {

    @Query("select a from AccountEntity a where a.user = :user")
    List<AccountEntity> findByUser(@Param("user") UserEntity user);

    @Query("select a from AccountEntity a where a.iban = :iban")
    AccountEntity findByIban(@Param("iban") String iban);
}
