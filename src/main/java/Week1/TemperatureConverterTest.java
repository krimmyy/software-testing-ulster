package Week1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TemperatureConverterTest {
    TemperatureConverter temperatureConverter = new TemperatureConverter();

    @Test
    void testFahrenheitToCelsius() {
        assertEquals(40, temperatureConverter.convertFahrenheitToCelsius());
    }

    @Test
    void testCelsiusToFahrenheit() {
        assertEquals(104, temperatureConverter.convertCelsiusToFahrenheit());
    }

}
