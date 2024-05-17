package portfolio;

import org.junit.Test;
import static org.junit.Assert.*;

public class CryptocurrencyTest {

    @Test
    public void shouldInitializeCryptocurrencyCorrectly() {
        Cryptocurrency crypto = new Cryptocurrency("Bitcoin", "BTC", 50000.0);

        assertEquals("Bitcoin", crypto.getName());
        assertEquals("BTC", crypto.getSymbol());
        assertEquals(50000.0, crypto.getPrice(), 0.01);
    }

    @Test
    public void shouldSetName() {
        Cryptocurrency crypto = new Cryptocurrency("Ethereum", "ETH", 3500.0);
        crypto.setName("Litecoin");

        assertEquals("Litecoin", crypto.getName());
    }

    @Test
    public void shouldSetSymbol() {
        Cryptocurrency crypto = new Cryptocurrency("Ripple", "XRP", 1.5);
        crypto.setSymbol("XLM");

        assertEquals("XLM", crypto.getSymbol());
    }

    @Test
    public void shouldSetPrice() {
        Cryptocurrency crypto = new Cryptocurrency("Cardano", "ADA", 1.2);
        crypto.setPrice(2.0);

        assertEquals(2.0, crypto.getPrice(), 0.01);
    }
}
