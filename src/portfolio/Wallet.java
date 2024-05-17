package portfolio;

import java.util.ArrayList;
import java.util.List;

// Class for representing user wallet
public class Wallet {
    private double balance;                  // Wallet balance (in USD)
    private List<Transaction> transactions;  // Transactions list

    // Class constructor
    public Wallet() {
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    // Method to add transaction to list
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    // Getter and setter for balance field
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Getter for transactions list
    public List<Transaction> getTransactions() {
        return transactions;
    }
}
