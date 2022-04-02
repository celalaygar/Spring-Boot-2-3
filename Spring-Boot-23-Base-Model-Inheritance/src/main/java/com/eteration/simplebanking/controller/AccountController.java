package com.eteration.simplebanking.controller;

import com.eteration.simplebanking.dto.RawDto;
import com.eteration.simplebanking.model.*;
import com.eteration.simplebanking.services.AccountService;
import com.eteration.simplebanking.services.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// This class is a place holder you can change the complete implementation
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private TransactionRepo transactionRepo;

    @RequestMapping(path = "/helo", method = RequestMethod.GET)
    public String hello() {
        Account account = new Account("Jim", "12345");
        account = accountService.createAccount(account);
        Transaction transaction = new DepositTransaction(1000.0);
        account.post(transaction);
        transactionRepo.save(transaction);
        transaction = new WithdrawalTransaction(200.0);
        account.post(transaction);
        transactionRepo.save(transaction);
        transaction = new PhoneBillPaymentTransaction("Vodafone", "5423345566", 96.0);
        account.post(transaction);
        transactionRepo.save(transaction);


        return "balanace " + account.getBalance();
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseEntity<Boolean> create(@RequestBody Account account) {
        return ResponseEntity.ok(accountService.create(account));
    }

    @RequestMapping(path = "/post/accountId", method = RequestMethod.POST)
    public ResponseEntity<Boolean> post(@PathVariable Long accountId, @RequestBody Transaction transaction) {
        return ResponseEntity.ok(accountService.post(accountId, transaction));
    }

    @RequestMapping(path = "/account/{accountId}", method = RequestMethod.GET)
    public ResponseEntity<Account> getAccount(@PathVariable Long accountId) {
        return ResponseEntity.ok(accountService.get(accountId));
    }

    @RequestMapping(path = "/credit/{number}", method = RequestMethod.POST)
    public ResponseEntity<Boolean> credit(@PathVariable String number, @RequestBody DepositTransaction transaction) {

        return ResponseEntity.ok(accountService.credit(number, transaction));
    }

    @RequestMapping(path = "/debit/{number}", method = RequestMethod.POST)
    public ResponseEntity<Boolean> debit(@PathVariable String number, @RequestBody WithdrawalTransaction transaction) {
        return ResponseEntity.ok(accountService.debit(number, transaction));
    }
    @RequestMapping(path = "/debit-with-phone/{number}", method = RequestMethod.POST)
    public ResponseEntity<Boolean> debitWithPhone(@PathVariable String number, @RequestBody PhoneBillPaymentTransaction trns) {
        return ResponseEntity.ok(accountService.debitWithPhone(number, trns));
    }

}