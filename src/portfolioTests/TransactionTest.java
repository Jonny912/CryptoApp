package portfolioTests;

import portfolio.Cryptocurrency;
import portfolio.Transaction;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TransactionTest {
    private Cryptocurrency btc;
    private Cryptocurrency eth;
    private Cryptocurrency ltc;

    @Before
    public void setUp() {
        btc = new Cryptocurrency("Bitcoin", "BTC", 50000.0);
        eth = new Cryptocurrency("Ethereum", "ETH", 2500.0);
        ltc = new Cryptocurrency("Litecoin", "LTC", 180.0);
    }

    @Test
    public void testTransactionConstructor() {
        Transaction transaction = new Transaction(Transaction.TransactionType.SELL, btc, 2.0, 50000.0);

        assertEquals(Transaction.TransactionType.SELL, transaction.getType());
        assertEquals(btc, transaction.getCurrency());
        assertEquals(2.0, transaction.getQuantity(), 0.001);
        assertEquals(50000.0, transaction.getPrice(), 0.001);
    }

    @Test
    public void testTransactionGetters() {
        Transaction transaction = new Transaction(Transaction.TransactionType.BUY, ltc, 2.5, 180.0);

        assertEquals(Transaction.TransactionType.BUY, transaction.getType());
        assertEquals(ltc, transaction.getCurrency());
        assertEquals(2.5, transaction.getQuantity(), 0.001);
        assertEquals(180.0, transaction.getPrice(), 0.001);
    }

    @Test
    public void testTransactionSetters() {
        Transaction transaction = new Transaction(Transaction.TransactionType.SELL, eth, 2.0, 2500.0);

        assertEquals(Transaction.TransactionType.SELL, transaction.getType());
        assertEquals(eth, transaction.getCurrency());
        assertEquals(2.0, transaction.getQuantity(), 0.001);
        assertEquals(2500.0, transaction.getPrice(), 0.001);

        // Change transaction details using setters
        transaction.setType(Transaction.TransactionType.BUY);
        transaction.setQuantity(3.0);
        transaction.setPrice(3000.0);

        assertEquals(Transaction.TransactionType.BUY, transaction.getType());
        assertEquals(3.0, transaction.getQuantity(), 0.001);
        assertEquals(3000.0, transaction.getPrice(), 0.001);
    }
}
