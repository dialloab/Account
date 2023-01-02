package com.societe.generale.service;

import com.societe.generale.beans.Transaction;
import com.societe.generale.beans.TypeOperation;
import com.societe.generale.exceptions.DepositIncorrectAmountException;
import com.societe.generale.exceptions.WithdrawalIncorrectAmountException;
import com.societe.generale.exceptions.WithdrawalInsufficentBalanceException;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.*;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
/**
 * Class to manage personal account bank.
 */
public class AccountBank {
    static final String THE_AMOUNT_CAN_T_BE_LESS_OR_EQUAL_THAN_0 = "The amount can't be less or equal than 0";
    static final String INSUFFICIENT_BALANCE = "Insufficient balance";
    static final String THE_AMOUNT_MUST_BE_GREATER_THAN_0 = "The amount must be greater than 0";
    final String accountNumber;
    final String name;
    double balance;
    final List<Transaction> transactions =  new ArrayList<>() ;


    /**
     * To make a deposit.
     * @param amountToDeposite
     *          The amount to deposit.
     * @throws DepositIncorrectAmountException
     */
    public void makeDeposit(final double amountToDeposite) throws DepositIncorrectAmountException{
        if(amountToDeposite <= 0){
            throw new DepositIncorrectAmountException(THE_AMOUNT_CAN_T_BE_LESS_OR_EQUAL_THAN_0);
        }
            balance += amountToDeposite;
            transactions.add(new Transaction(amountToDeposite, new Date(), TypeOperation.DEPOSIT, balance));

    }

    /**
     * To make a withdrawal.
     * @param amountToWithDraw
     *          the amount to withdraw.
     * @throws WithdrawalInsufficentBalanceException
     * @throws WithdrawalIncorrectAmountException
     */
    public void makeWithdrawal(final double amountToWithDraw) throws WithdrawalInsufficentBalanceException, WithdrawalIncorrectAmountException {
        if(amountToWithDraw > balance) {
            throw new WithdrawalInsufficentBalanceException(INSUFFICIENT_BALANCE);
        }
        if(amountToWithDraw <=0){
            throw new WithdrawalIncorrectAmountException(THE_AMOUNT_MUST_BE_GREATER_THAN_0);
        }
            balance -= amountToWithDraw;
            transactions.add(new Transaction(amountToWithDraw, new Date(), TypeOperation.WITHDRAWAL, balance));

    }

    /**
     * Display the history of transactions.
     */
    public void displayHistory(){
        transactions.stream().sorted(Comparator.comparing(Transaction::getDateTransaction)).forEach(System.out::println);
    }
}
