package com.societe.generale.beans;

import java.util.Date;

/**
 * The class that represent a bank transaction.
 */
public record Transaction(double amount, Date dateTransaction, TypeOperation type,
                          double balance) {

    public Date getDateTransaction(){
        return dateTransaction;
    }
    @Override
    public String toString() {
        return "Transaction {" +
                "amount=" + amount +
                ", dateTransaction=" + dateTransaction +
                ", type transaction=" + type +
                ", balance=" + balance +
                '}';
    }
}
