package portfolioTests;
import org.junit.Before;
import org.junit.Test;
import portfolio.*;

import static org.junit.Assert.*;

public class PortfolioTest {
    private Portfolio portfolio;
    private Cryptocurrency bitcoin;
    private Cryptocurrency ethereum;

    @Before
    public void setUp() {
        portfolio = new Portfolio();
        bitcoin = new Cryptocurrency("Bitcoin", "BTC", 50000.0);
        ethereum = new Cryptocurrency("Ethereum", "ETH", 4000.0);
    }

    @Test
    public void testBuyCryptocurrency() {
        portfolio.getWallet().setBalance(100000.0);
        portfolio.buyCryptocurrency(bitcoin, 1.0, 50000.0);

        assertEquals(50000.0, portfolio.getWallet().getBalance(), 0.0001);
        assertEquals(1, portfolio.getWallet().getTransactions().size());

        Transaction transaction = portfolio.getWallet().getTransactions().get(0);
        assertEquals(Transaction.TransactionType.BUY, transaction.getType());
        assertEquals(bitcoin, transaction.getCurrency());
        assertEquals(1.0, transaction.getQuantity(), 0.0001);
        assertEquals(50000.0, transaction.getPrice(), 0.0001);
    }

    @Test
    public void testBuyCryptocurrencyInsufficientFunds() {
        portfolio.getWallet().setBalance(10000.0);
        portfolio.buyCryptocurrency(bitcoin, 1.0, 50000.0);

        assertEquals(10000.0, portfolio.getWallet().getBalance(), 0.0001);
        assertEquals(0, portfolio.getWallet().getTransactions().size());
    }

    @Test
    public void testSellCryptocurrency() {
        portfolio.getWallet().setBalance(50000.0);
        portfolio.buyCryptocurrency(bitcoin, 1.0, 50000.0);
        portfolio.sellCryptocurrency(bitcoin, 0.5, 60000.0);

        assertEquals(30000.0, portfolio.getWallet().getBalance(), 0.0001);
        assertEquals(2, portfolio.getWallet().getTransactions().size());

        Transaction sellTransaction = portfolio.getWallet().getTransactions().get(1);
        assertEquals(Transaction.TransactionType.SELL, sellTransaction.getType());
        assertEquals(bitcoin, sellTransaction.getCurrency());
        assertEquals(0.5, sellTransaction.getQuantity(), 0.0001);
        assertEquals(60000.0, sellTransaction.getPrice(), 0.0001);
    }

    @Test
    public void testSellCryptocurrencyInsufficientQuantity() {
        portfolio.getWallet().setBalance(60000.0);
        portfolio.buyCryptocurrency(bitcoin, 1.0, 50000.0);
        portfolio.sellCryptocurrency(bitcoin, 2.0, 60000.0);

        assertEquals(10000.0, portfolio.getWallet().getBalance(), 0.0001);
        assertEquals(1, portfolio.getWallet().getTransactions().size());
    }

    @Test
    public void testGetAvailableQuantity() {
        portfolio.getWallet().setBalance(100000.0);
        portfolio.buyCryptocurrency(bitcoin, 1.0, 50000.0);
        portfolio.sellCryptocurrency(bitcoin, 0.5, 60000.0);

        // Using reflection to access private method getAvailableQuantity
        try {
            java.lang.reflect.Method method = Portfolio.class.getDeclaredMethod("getAvailableQuantity", Cryptocurrency.class);
            method.setAccessible(true);
            double availableQuantity = (double) method.invoke(portfolio, bitcoin);
            assertEquals(0.5, availableQuantity, 0.0001);
        } catch (Exception e) {
            fail("Exception thrown while accessing getAvailableQuantity: " + e.getMessage());
        }
    }
}

