package com.acme.securecodingpractices.objectconstruction;

public class InsecureBankAccount {
    private String accountHolderName;
    private double balance;

    public InsecureBankAccount(String accountHolderName, double balance) {
        // No validation
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        // Insecure usage example
        InsecureBankAccount account = new InsecureBankAccount(null, -500.0); // Invalid state allowed
        System.out.println("Account Holder: " + account.getAccountHolderName());
        System.out.println("Balance: " + account.getBalance());
    }
}
