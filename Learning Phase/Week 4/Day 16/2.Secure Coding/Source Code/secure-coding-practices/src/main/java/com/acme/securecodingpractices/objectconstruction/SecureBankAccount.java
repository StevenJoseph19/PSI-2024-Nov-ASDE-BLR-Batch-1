package com.acme.securecodingpractices.objectconstruction;

public final class SecureBankAccount {
    private final String accountHolderName;
    private final double balance;

    public SecureBankAccount(String accountHolderName, double balance) {
        if (accountHolderName == null || accountHolderName.isBlank()) {
            throw new IllegalArgumentException("Account holder name must not be null or blank.");
        }
        if (balance < 0) {
            throw new IllegalArgumentException("Balance must be non-negative.");
        }

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
        // Secure usage example
        try {
            SecureBankAccount account = new SecureBankAccount("John Doe", 1000.0);
            System.out.println("Account Holder: " + account.getAccountHolderName());
            System.out.println("Balance: " + account.getBalance());

            // Attempting invalid initialization
            SecureBankAccount invalidAccount = new SecureBankAccount(null, -500.0);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
