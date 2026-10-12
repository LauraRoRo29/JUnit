import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PurchaseCalculatorTest {

    private final PurchaseCalculator calculator = new PurchaseCalculator();
    private final double DELTA = 0.001;

    @Test
    public void testCalculateSubtotalStandard() {
        assertEquals(300.0, calculator.calculateSubtotal(100.0, 3), DELTA);
    }

    @Test
    public void testCalculateSubtotalSingleItem() {
        assertEquals(50.0, calculator.calculateSubtotal(50.0, 1), DELTA);
    }

    @Test
    public void testCalculateSubtotalZeroPrice() {
        assertEquals(0.0, calculator.calculateSubtotal(0.0, 5), DELTA);
    }

    @Test
    public void testIsValidPurchaseValid() {
        assertTrue(calculator.isValidPurchase(100.0, 2));
    }

    @Test
    public void testIsValidPurchaseZeroPrice() {
        assertFalse(calculator.isValidPurchase(0.0, 2));
    }

    @Test
    public void testIsValidPurchaseZeroQuantity() {
        assertFalse(calculator.isValidPurchase(100.0, 0));
    }

    @Test
    public void testIsValidPurchaseNegativePrice() {
        assertFalse(calculator.isValidPurchase(-10.0, 2));
    }

    @Test
    public void testCalculateDiscountBelowThreshold() {
        assertEquals(0.0, calculator.calculateDiscount(999.99), DELTA);
    }

    @Test
    public void testCalculateDiscountExactThreshold() {
        assertEquals(100.0, calculator.calculateDiscount(1000.0), DELTA);
    }

    @Test
    public void testCalculateDiscountAboveThreshold() {
        assertEquals(150.0, calculator.calculateDiscount(1500.0), DELTA);
    }

    @Test
    public void testCalculateFinalPriceWithoutDiscount() {
        assertEquals(500.0, calculator.calculateFinalPrice(500.0), DELTA);
    }

    @Test
    public void testCalculateFinalPriceWithDiscount() {
        assertEquals(900.0, calculator.calculateFinalPrice(1000.0), DELTA);
    }
}
