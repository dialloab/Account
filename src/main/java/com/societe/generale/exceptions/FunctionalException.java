package com.societe.generale.exceptions;

/**
 * Allow to manage all functional exceptions.
 */
public  abstract class FunctionalException extends Exception {

    public FunctionalException(final String message) {
        super(message);
    }
}
