package com.eteration.simplebanking.services;


import com.eteration.simplebanking.dto.RawDto;
import com.eteration.simplebanking.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private  AccountRepo accountRepo;
    @Autowired
    private  TransactionRepo transactionRepo;

    public boolean create( Account account){
        ;
        Optional<Account> opt = accountRepo.findByNumber(account.getNumber());
        if(opt.isPresent())
            return false;
        account = accountRepo.save(account);
        if (account.getAccountId() == null) {
            return false;
        }
        return true;
    }
    public Account createAccount(Account account){
        account = accountRepo.save(account);
        if (account.getAccountId() == null) {
            return null;
        }
        return account;
    }

    public boolean post(Long accountId, Transaction transaction) {

        Optional<Account> account = accountRepo.findById(accountId);
        if(!account.isPresent())
            return false;
        Account acc= account.get();
        acc.post(transaction);
        transactionRepo.save(transaction);
        return true;
    }

    public boolean debitWithPhone(String number, PhoneBillPaymentTransaction trns) {
        Optional<Account> account = accountRepo.findByNumber(number);
        if(!account.isPresent())
            return false;
        Account acc= account.get();
        if(  acc.getBalance() <= 0 || acc.getBalance() <trns.getAmount() )
            return false;
        Transaction transaction = new PhoneBillPaymentTransaction(trns.getPhoneType(), trns.getPhoneNumber(), trns.getAmount());
        acc.post(transaction);
        transactionRepo.save(transaction);
        return true;
    }
    public boolean debit(String number, Transaction dto) {
        Optional<Account> account = accountRepo.findByNumber(number);
        if(!account.isPresent())
            return false;
        Account acc= account.get();
        if(  acc.getBalance() <= 0.0 || acc.getBalance() <dto.getAmount() )
            return false;
        Transaction transaction = new WithdrawalTransaction(dto.getAmount());
        acc.post(transaction);
        transactionRepo.save(transaction);
        return true;
    }
    public boolean credit(String number, Transaction dto) {

        Optional<Account> account = accountRepo.findByNumber(number);
        if(!account.isPresent())
            return false;
        Account acc= account.get();
        Transaction transaction = new DepositTransaction(dto.getAmount());
        acc.post(transaction);
        transactionRepo.save(transaction);
        return true;
    }
    public Account get(Long accountId) {

        Optional<Account> account = accountRepo.findById(accountId);
        if(!account.isPresent())
            return null;
        return account.get();
    }
    public Account findAccount(String number) {

        Optional<Account> account = accountRepo.findByNumber(number);
        if(!account.isPresent())
            return null;
        return account.get();
    }
}
