package com.societe.generale.exceptions;

/**
 * This exception class manage insufficient amount for withdrawal.
 * If the amount to withdraw is greater than the balance.
 */
public class WithdrawalInsufficentBalanceException extends FunctionalException {

    public WithdrawalInsufficentBalanceException(final String message) {
        super(message);
    }
}
