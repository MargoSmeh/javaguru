package service;

import com.javaguru.shoppinglist.service.CalculateActualPrice;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertTrue;

public class CalculateActualPriceTest {

    private CalculateActualPrice victim = new CalculateActualPrice();

    @Test
    public void shouldCalculateDiscount() {
        BigDecimal discountValue = victim.calculateDiscount(new BigDecimal(250), new BigDecimal(20));
        assertTrue(new BigDecimal(50).compareTo(discountValue) == 0);
    }

    @Test
    public void shouldCalculateActualPrice(){
        BigDecimal actualPrice = victim.calculateActualPrice(new BigDecimal(600),new BigDecimal(10));
        assertTrue(new BigDecimal(540).compareTo(actualPrice)==0);
    }
}