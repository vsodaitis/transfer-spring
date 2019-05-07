package com.vytenis.transfer.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class PaymentEntity {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private AccountEntity debtor;

    @ManyToOne
    private AccountEntity beneficiary;

    private BigDecimal sum;

    private String currency;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    private LocalDateTime date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccountEntity getDebtor() {
        return debtor;
    }

    public void setDebtor(AccountEntity debtor) {
        this.debtor = debtor;
    }

    public AccountEntity getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(AccountEntity beneficiary) {
        this.beneficiary = beneficiary;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
