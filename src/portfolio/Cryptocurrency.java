package portfolio;

// Class for representing cryptocurrency
public class Cryptocurrency {
    private String name;    // Cryptocurrency name
    private String symbol;  // Cryptocurrency symbol
    private double price;   // Cryptocurrency price in USD

    // Class constructor
    public Cryptocurrency(String name, String symbol, double price) {
        this.name = name;
        this.symbol = symbol;
        this.price = price;
    }

    // Getters and setters for class fields
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
