package com.vytenis.transfer.dao;

import com.vytenis.transfer.entity.AccountEntity;
import com.vytenis.transfer.entity.PaymentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PaymentDao extends CrudRepository<PaymentEntity, Long> {

    @Query("select p from PaymentEntity p where p.beneficiary = :beneficiary")
    List<PaymentEntity> findAllByBeneficiary(@Param("beneficiary") AccountEntity beneficiary);

    @Query("select p from PaymentEntity p where p.debtor = :debtor")
    List<PaymentEntity> findAllByDebtor(@Param("debtor") AccountEntity debtor);

    @Query("select p from PaymentEntity p order by date desc")
    List<PaymentEntity> findAllSortByDate();
}
