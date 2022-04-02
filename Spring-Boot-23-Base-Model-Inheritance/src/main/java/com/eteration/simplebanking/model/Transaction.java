package com.eteration.simplebanking.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Transaction {

    @Id
    @Column(name = "transaction_id", nullable = false)
    @GeneratedValue
    private Long transactionId;

    private Date date;

    protected Double amount;

    public Transaction() {
    }
    public Transaction(Double amount) {
        this.amount = amount;
        this.date = new Date();
    }
    public Transaction(Date date, Double amount, Account account) {
        this.date = date;
        this.amount = amount;
        this.account = account;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="account_id", referencedColumnName = "account_id", nullable = true)
    private Account account;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Date getDate() {
        return date;
    }


    public void setDate(Date date) {
        this.date = date != null ? date : new Date();
    }


}
