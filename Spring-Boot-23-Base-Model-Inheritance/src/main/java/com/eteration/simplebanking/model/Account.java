package com.eteration.simplebanking.model;


// This class is a place holder you can change the complete implementation


import com.eteration.simplebanking.services.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="account")
@Table(name="account")
public class Account {

    @Id
    @Column(name = "account_id", nullable = false)
    @GeneratedValue
    private Long accountId;

    private Double balance ;
    private String number ;
    private String owner;

    @OneToMany(mappedBy = "account", targetEntity =  Transaction.class)
    private List<Transaction> transactions;

    public Account() {
        this.balance= 0D;
    }

    public Account( String owner, String number) {
        this.number = number;
        this.owner = owner;
        this.balance = 0D;
    }

    public void post(Transaction transaction){
        transaction.setAccount(this);
        if(this.transactions == null){
            this.transactions = new ArrayList<>();
        }
        this.transactions.add(transaction);
        this.balance += transaction.amount;
    }

    public void credit(Double amount ) {
        balance = balance + amount;
    }

    public void debit(Double suppliedAmount) {
        balance = balance - suppliedAmount;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Double getBalance() {
        return balance;
    }

    public String getNumber() {
        return number;
    }

    public String getOwner() {
        return owner;
    }
}
