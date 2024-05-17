package portfolio;

public class Main {
    public static void main(String[] args) {
        // Create portfolio
        Portfolio portfolio = new Portfolio();

        // Create cryptocurrencies
        Cryptocurrency bitcoin = new Cryptocurrency("Bitcoin", "BTC", 50000);
        Cryptocurrency ethereum = new Cryptocurrency("Ethereum", "ETH", 3000);

        // Add cryptocurrencies to portfolio
        portfolio.getCurrencies().add(bitcoin);
        portfolio.getCurrencies().add(ethereum);

        // Set initial wallet balance
        portfolio.getWallet().setBalance(1000000); // Initial wallet balance: $1,000,000

        // Perform buy and sell transactions
        performTransaction(portfolio, TransactionType.BUY, bitcoin, 0.5, bitcoin.getPrice());  // Buy 0.5 BTC

        performTransaction(portfolio, TransactionType.SELL, bitcoin, 0.2, bitcoin.getPrice()); // Sell 0.2 BTC

        // Buy more Ethereum
        performTransaction(portfolio, TransactionType.BUY, ethereum, 5, ethereum.getPrice());  // Buy 5 ETH

        // Sell some Ethereum
        performTransaction(portfolio, TransactionType.SELL, ethereum, 2, ethereum.getPrice()); // Sell 2 ETH
    }

    private static void performTransaction(Portfolio portfolio, TransactionType type,
                                           Cryptocurrency currency, double quantity, double price) {
        if (type == TransactionType.BUY)
        {
            portfolio.buyCryptocurrency(currency, quantity, price);
        }
        else
        {
            portfolio.sellCryptocurrency(currency, quantity, price);
        }
        // Output transaction details
        System.out.println(type + " Transaction: " + quantity + " " + currency.getSymbol() +
                " at $" + price + " each. Wallet Balance: $" + portfolio.getWallet().getBalance());
    }
}
