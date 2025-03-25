package test;

import main.PasswordValidator;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PasswordValidatorTest {

    @Test
    void shouldValidateStrongPassword() {
        assertThat(PasswordValidator.isValidPassword("Valid_#1A")).isTrue();
    }

    @Test
    void shouldRejectShortPassword() {
        assertThat(PasswordValidator.isValidPassword("Short1#")).isFalse();
    }

    @Test
    void shouldRejectPasswordWithoutDigit() {
        assertThat(PasswordValidator.isValidPassword("NoDigits_#A")).isFalse();
    }

    @Test
    void shouldRejectPasswordWithoutLowercase() {
        assertThat(PasswordValidator.isValidPassword("ALLUPPER_#1")).isFalse();
    }

    @Test
    void shouldRejectPasswordWithoutUppercase() {
        assertThat(PasswordValidator.isValidPassword("alllower_#1")).isFalse();
    }

    @Test
    void shouldRejectPasswordWithoutSpecialCharacter() {
        assertThat(PasswordValidator.isValidPassword("NoSpecial1A")).isFalse();
    }

    @Test
    void shouldRejectPasswordWithSpaces() {
        assertThat(PasswordValidator.isValidPassword("Has Space_#1A")).isFalse();
    }
}
