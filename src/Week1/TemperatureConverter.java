package Week1;

public class TemperatureConverter {

    public double convertFahrenheitToCelsius() {
        double f = 104;
        double c = (f - 32) / 1.8;
        return c;
    }

    public double convertCelsiusToFahrenheit() {
        double c = 40;
        double f = (c * 1.8) + 32;
        return f;
    }
}
