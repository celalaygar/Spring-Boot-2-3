package com.eteration.simplebanking.model;


// This class is a place holder you can change the complete implementation

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity(name="depositTransaction")
@Table(name="depositTransaction")
public class DepositTransaction  extends  Transaction {

    private String type;
    public DepositTransaction(Double amount) {
        super(new Date(), amount, null);
        type = "depositTransaction";
    }

    public DepositTransaction() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = "withdrawalTransaction";
    }

}
