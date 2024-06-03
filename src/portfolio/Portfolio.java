package portfolio;

import java.util.ArrayList;
import java.util.List;

// Class for managing cryptocurrency portfolio
public class Portfolio {
    final private Wallet wallet;                    // User wallet
    final private List<Cryptocurrency> currencies;  // Available cryptocurrencies

    // Class constructor
    public Portfolio() {
        this.wallet = new Wallet();
        this.currencies = new ArrayList<>();
    }

    // Method for buying cryptocurrency
    public void buyCryptocurrency(Cryptocurrency currency, double quantity, double price) {
        // Calculate purchase cost
        double totalCost = quantity * price;
        // Check if enough funds in wallet balance
        if (wallet.getBalance() >= totalCost) {
            // Decrease wallet balance
            wallet.setBalance(wallet.getBalance() - totalCost);
            // Add transaction to list
            wallet.addTransaction(new Transaction(Transaction.TransactionType.BUY, currency, quantity, price));
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    // Method for selling cryptocurrency
    public void sellCryptocurrency(Cryptocurrency currency, double quantity, double price) {
        // Check if specified quantity of cryptocurrency is available in wallet
        double availableQuantity = getAvailableQuantity(currency);
        if (availableQuantity >= quantity) {
            // Calculate revenue from sale
            double totalRevenue = quantity * price;
            // Increase wallet balance
            wallet.setBalance(wallet.getBalance() + totalRevenue);
            // Add transaction to list
            wallet.addTransaction(new Transaction(Transaction.TransactionType.SELL, currency, quantity, price));
        } else {
            System.out.println("Insufficient quantity of " + currency.getName() + " in wallet!");
        }
    }

    // Method to get available quantity of specified cryptocurrency in wallet
    private double getAvailableQuantity(Cryptocurrency currency) {
        double totalQuantity = 0;
        // Iterate through transactions list and sum cryptocurrency quantity
        for (Transaction transaction : wallet.getTransactions()) {
            if (transaction.getCurrency().equals(currency)) {
                if (transaction.getType() == Transaction.TransactionType.BUY) {
                    totalQuantity += transaction.getQuantity();
                } else if (transaction.getType() == Transaction.TransactionType.SELL) {
                    totalQuantity -= transaction.getQuantity();
                }
            }
        }
        return totalQuantity;
    }

    // Getter for wallet
    public Wallet getWallet() {
        return wallet;
    }

    // Getter for available cryptocurrencies list
    public List<Cryptocurrency> getCurrencies() {
        return currencies;
    }
}
