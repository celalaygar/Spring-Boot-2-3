package com.eteration.simplebanking.model;


// This class is a place holder you can change the complete implementation

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity(name="phoneBillPaymentTransaction")
@Table(name="phoneBillPaymentTransaction")
public class PhoneBillPaymentTransaction extends  Transaction {

    private String phoneType;
    private String type;
    private String phoneNumber;

    public PhoneBillPaymentTransaction(Double amount) {
        type = "phoneBillPaymentTransaction";
    }

    public PhoneBillPaymentTransaction() {
    }

    public PhoneBillPaymentTransaction(String phoneType, String phoneNumber, Double amount) {
        super(new Date(),  0.0 - amount, null);
        this.phoneType = phoneType;
        this.phoneNumber = phoneNumber;
        type = "phoneBillPaymentTransaction";
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = "phoneBillPaymentTransaction";
    }

}
