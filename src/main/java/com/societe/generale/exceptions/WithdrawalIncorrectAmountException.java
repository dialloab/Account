package com.societe.generale.exceptions;

/**
 * This exception class manage incorrect amount for withdrawal.
 * If the amount is less or equals to 0.
 */
public class WithdrawalIncorrectAmountException extends FunctionalException{
    public WithdrawalIncorrectAmountException(final String message){
        super(message);
    }
}
