// File: Transaction.java
package portfolio; // portfolio/utils


// Enumeration for representing transaction type
enum TransactionType {
    BUY, SELL
}

// Class for representing cryptocurrency buy or sell transaction
public class Transaction {
    private TransactionType type;       // Transaction type
    private Cryptocurrency currency;    // Cryptocurrency associated with transaction
    private double quantity;            // Cryptocurrency quantity
    private double price;               // Cryptocurrency price at time of transaction

    // Class constructor
    public Transaction(TransactionType type, Cryptocurrency currency, double quantity, double price) {
        this.type = type;
        this.currency = currency;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and setters for class fields
    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public Cryptocurrency getCurrency() {
        return currency;
    }

    public void setCurrency(Cryptocurrency currency) {
        this.currency = currency;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
