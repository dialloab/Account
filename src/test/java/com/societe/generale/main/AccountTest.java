package com.societe.generale.main;

import com.societe.generale.exceptions.DepositIncorrectAmountException;
import com.societe.generale.exceptions.WithdrawalIncorrectAmountException;
import com.societe.generale.exceptions.WithdrawalInsufficentBalanceException;
import com.societe.generale.service.AccountBank;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for Bank Account Class.
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AccountTest {

    public static final int AMOUNT_TO_DEPOSIT_OK = 250;
    public static final int AMOUNT_TO_DEPOSIT_KO = -1;
    public static final int AMOUNT_TO_WITHDRAWAL_LESS_THAN_BALANCE = 100;
    public static final int AMOUNT_TO_WITHDRAWAL_MORE_THAN_BALANCE = 200;
    public static final int AMOUNT_TO_WITHDRAWAL_EQUAL_TO_ZERO = 0;
    private static AccountBank account;

    @BeforeAll
    static void beforeAll() {
        account = new AccountBank("accountNumberOne","Abdoulaye",0.0);
    }

    @Test
    @Order(1)
    void testDepositOk() throws DepositIncorrectAmountException {
      int numberCurrentTransaction = account.getTransactions().size();
      this.account.makeDeposit(AMOUNT_TO_DEPOSIT_OK);
      assertEquals(numberCurrentTransaction + 1,account.getTransactions().size());
    }

    @Test
    @Order(2)
    void testDepositKO() {
        DepositIncorrectAmountException depositException =  assertThrows(DepositIncorrectAmountException.class, () -> this.account.makeDeposit(AMOUNT_TO_DEPOSIT_KO));
        assertEquals("The amount can't be less or equal than 0",depositException.getMessage());
    }

    @Test
    @Order(3)
    void testWithdrawalAmountLessThanBalanceOk() throws WithdrawalIncorrectAmountException, WithdrawalInsufficentBalanceException {
        int numberCurrentTransaction = account.getTransactions().size();
        this.account.makeWithdrawal(AMOUNT_TO_WITHDRAWAL_LESS_THAN_BALANCE);
        assertEquals(numberCurrentTransaction + 1, account.getTransactions().size());
    }

    @Test
    @Order(4)
    void testWithdrawalAmountMoreThanBalanceKO() {
        WithdrawalInsufficentBalanceException insufficentBalanceException = assertThrows(WithdrawalInsufficentBalanceException.class,() -> this.account.makeWithdrawal(AMOUNT_TO_WITHDRAWAL_MORE_THAN_BALANCE));
        assertEquals("Insufficient balance" , insufficentBalanceException.getMessage());
    }

    @Test
    @Order(5)
    void testWithdrawalAmountEqualToZeroKO() {
        WithdrawalIncorrectAmountException incorrectAmountException = assertThrows(WithdrawalIncorrectAmountException.class,() -> this.account.makeWithdrawal(AMOUNT_TO_WITHDRAWAL_EQUAL_TO_ZERO));
        assertEquals("The amount must be greater than 0" , incorrectAmountException.getMessage());
    }
}