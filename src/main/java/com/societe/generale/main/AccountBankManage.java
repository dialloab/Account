package com.societe.generale.main;

import com.societe.generale.exceptions.DepositIncorrectAmountException;
import com.societe.generale.exceptions.WithdrawalIncorrectAmountException;
import com.societe.generale.exceptions.WithdrawalInsufficentBalanceException;
import com.societe.generale.service.AccountBank;

import java.util.Scanner;

/**
 * Class that launch the personal bank account.
 */
public class AccountBankManage {
    private static final Scanner scanner= new Scanner(System.in);

    public static void main(String[] args){
      Scanner scanner = new Scanner(System.in);
      AccountBank account = new AccountBank("123L1456","Abdoulaye",0.0);
      int choice;
        do{
            System.out.println("""
            ********* Please, make your choice to manage your personal account ******** 
            1 to make a deposit
            2 to make a withdrawal
            3 to display history of transactions
            4 to exit
            ******************************************************************************
            """);

            System.out.print("Ready ? Enter your choice ");

            choice = scanner.nextInt();

            switch (choice){
                case 1:
                    deposit(account);
                    break;
                case 2:
                    withdrawal(account);
                    break;
                case 3:
                    History(account);
                    break;
                case 4:
                    System.out.println("Bye bye");
                default:
                    if(choice != 4) {
                        System.out.println("Your choice is invalid, retry please ! ! !");
                    }
            }
        }while(choice != 4 );
    }

    /**
     * Allow to check the amount entered.
     * @return
     *        the valid amount.
     */
    private static double enterAmount(){
        double amount;
        do {
            System.out.println("Please, enter the amount that you want");
            amount =  scanner.nextDouble();

            if (amount <= 0) {
                System.out.println("The amount must be greater than 0");
            }
        }while(amount<=0);

        return amount;
    }

    private static void History(AccountBank account) {
        System.out.println("========= Start Display history transactions ========================= ");
        account.displayHistory();
        System.out.println("========= End Display history transactions ===========================");
    }

    private static void withdrawal(AccountBank account)  {
        System.out.println("========= Start withdrawal ========================================== ");
        try {
            account.makeWithdrawal(enterAmount());
        }
        catch (WithdrawalInsufficentBalanceException insufficientException){
          System.out.println(insufficientException.getMessage());
        }
        catch (WithdrawalIncorrectAmountException incorrectAmountException){
            System.out.println(incorrectAmountException.getMessage());
        }
        System.out.println("========= End withdrawal ============================================ ");
    }

    private static void deposit(AccountBank account) {
        System.out.println("========= Start deposit ========================================== ");
        try {
            account.makeDeposit(enterAmount());
        }
        catch(DepositIncorrectAmountException d){
            System.out.println(d.getMessage());
        }
        System.out.println("========= End deposit ============================================ ");
    }
}
