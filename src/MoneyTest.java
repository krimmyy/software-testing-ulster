import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class MoneyTest {

    @ParameterizedTest
    @CsvSource({
            "10, 'USD', 10, 'USD', true",           // Same amount and currency, should be equal
            "5, 'EUR', 5, 'EUR', true",             // Same amount and currency, should be equal
            "10, 'USD', 20, 'USD', false",         // Same currency but different amounts, should not be equal
            "10, 'USD', 10, 'EUR', false",         // Same amount but different currencies, should not be equal
            "0, 'USD', 0, 'USD', true",            // Zero amount, same currency, should be equal
            "100, 'GBP', 100, 'GBP', true",        // Same amount and currency, should be equal
            "10, 'USD', 10, '', false"             // Invalid currency (empty), should fail
    })
    void testMoneyEquals(int amount1, String currency1, int amount2, String currency2, boolean expected) {
        Money money1 = new Money(amount1, currency1);
        Money money2 = new Money(amount2, currency2);
        assertEquals(expected, money1.equals(money2));
    }

    @Test
    void testAdd() {
        Money money1 = new Money(10, "USD");
        Money money2 = new Money(5, "USD");

        Money result = money1.add(money2);
        assertEquals(15, result.getAmount());
        assertEquals("USD", result.getCurrency());
    }

    @Test
    void testAddDifferentCurrencies() {
        Money money1 = new Money(10, "EUR");
        Money money2 = new Money(5, "USD");

        assertThrows(IllegalArgumentException.class, () -> {
            money1.add(money2);
        });
    }

    @Test
    void testInvalidMoneyAmount() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Money(-1, "EUR");
        });
    }

    @Test
    void testInvalidCurrency() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Money(10, "");
        });
    }

    @Test
    void testMoneyToString() {
        Money money = new Money(100, "EUR");
        assertEquals("Money{amount=100, currency='USD'}", money.toString());
        }
    }
