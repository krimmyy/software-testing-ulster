package test;

import main.FahrenheitCelsiusConverter;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class FahrenheitCelsiusConverterTest {

    @Test
    void shouldConvertCelsiusToFahrenheit() {
        assertThat(FahrenheitCelsiusConverter.toFahrenheit(0)).isEqualTo(32);
        assertThat(FahrenheitCelsiusConverter.toFahrenheit(37)).isEqualTo(98.6);
        assertThat(FahrenheitCelsiusConverter.toFahrenheit(100)).isEqualTo(212);
    }

    @Test
    void shouldConvertFahrenheitToCelsius() {
        assertThat(FahrenheitCelsiusConverter.toCelsius(32)).isEqualTo(0);
        assertThat(FahrenheitCelsiusConverter.toCelsius(98.6)).isEqualTo(37);
        assertThat(FahrenheitCelsiusConverter.toCelsius(212)).isEqualTo(100);
    }
}
