package com.eteration.simplebanking.model;


// This class is a place holder you can change the complete implementation

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity(name="withdrawalTransaction")
@Table(name="withdrawalTransaction")
public class WithdrawalTransaction extends  Transaction{

    private String type;

    public WithdrawalTransaction(String type) {
        this.type = type;
    }

    public WithdrawalTransaction() {
    }

    public WithdrawalTransaction(Double amount) {
        super(new Date(), 0 - amount, null);
        type = "withdrawalTransaction";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = "withdrawalTransaction";
    }
}


