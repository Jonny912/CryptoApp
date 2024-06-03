package portfolioTests;

import portfolio.Cryptocurrency;

import org.junit.Test;
import static org.junit.Assert.*;

public class CryptocurrencyTest {

    @Test
    public void testCryptocurrencyCreation() {
        Cryptocurrency bitcoin = new Cryptocurrency("Bitcoin", "BTC", 50000.0);
        assertEquals("Bitcoin", bitcoin.getName());
        assertEquals("BTC", bitcoin.getSymbol());
        assertEquals(50000.0, bitcoin.getPrice(), 0.0001);
    }

    @Test
    public void testSetPrice() {
        Cryptocurrency bitcoin = new Cryptocurrency("Bitcoin", "BTC", 50000.0);
        bitcoin.setPrice(55000.0);
        assertEquals(55000.0, bitcoin.getPrice(), 0.0001);
    }
}
