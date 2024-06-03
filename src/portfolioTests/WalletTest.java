package portfolioTests;

import org.junit.Before;
import org.junit.Test;
import portfolio.Transaction;
import portfolio.Cryptocurrency;
import portfolio.Wallet;

import java.util.List;

import static org.junit.Assert.*;

public class WalletTest {
    private Wallet wallet;
    private Cryptocurrency bitcoin;
    private Cryptocurrency ethereum;

    @Before
    public void setUp() {
        wallet = new Wallet();
        bitcoin = new Cryptocurrency("Bitcoin", "BTC", 50000.0);
        ethereum = new Cryptocurrency("Ethereum", "ETH", 4000.0);
    }

    @Test
    public void testInitialBalance() {
        assertEquals(0.0, wallet.getBalance(), 0.0001);
    }

    @Test
    public void testSetBalance() {
        wallet.setBalance(1000.0);
        assertEquals(1000.0, wallet.getBalance(), 0.0001);
    }

    @Test
    public void testAddTransaction() {
        Transaction transaction = new Transaction(Transaction.TransactionType.BUY, bitcoin, 1.0, 50000.0);
        wallet.addTransaction(transaction);
        List<Transaction> transactions = wallet.getTransactions();
        assertEquals(1, transactions.size());
        assertEquals(transaction, transactions.get(0));
    }

    @Test
    public void testGetTransactions() {
        Transaction transaction1 = new Transaction(Transaction.TransactionType.BUY, bitcoin, 1.0, 50000.0);
        Transaction transaction2 = new Transaction(Transaction.TransactionType.SELL, ethereum, 2.0, 4000.0);
        wallet.addTransaction(transaction1);
        wallet.addTransaction(transaction2);
        List<Transaction> transactions = wallet.getTransactions();
        assertEquals(2, transactions.size());
        assertEquals(transaction1, transactions.get(0));
        assertEquals(transaction2, transactions.get(1));
    }
}
