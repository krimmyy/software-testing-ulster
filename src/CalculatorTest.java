import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void testAdditionValid() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    void testAdditionInvalid() {
        assertEquals(15, calculator.add(14, 6));
    }


    @Test
    void testSubtractionValid() {
        assertEquals(3, calculator.subtract(7, 4));
    }

    @Test
    void testSubtractionInvalid() {
        assertEquals(13, calculator.subtract(5, 8));
    }
}
