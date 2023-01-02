package com.societe.generale.exceptions;

/**
 * This exception class manage incorrect amount for deposit.
 * If the amount is less or equals to 0.
 */
public class DepositIncorrectAmountException extends FunctionalException {

    public DepositIncorrectAmountException(final String message) {
        super(message);
    }
}
