package com.societe.generale.beans;

/**
 * The type of operation that are allowed in our bank.
 */
public enum TypeOperation {
    DEPOSIT("deposit"),
    WITHDRAWAL("withdrawal");

   final String name;

    TypeOperation(final String name) {
        this.name = name;
    }
}
