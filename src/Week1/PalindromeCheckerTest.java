package Week1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromeCheckerTest {
    PalindromeChecker palindromeChecker = new PalindromeChecker();

    @Test
    void testISPalindromeWithPalindrome() {
        // Test case using a string which is palindrome
        assertTrue(PalindromeChecker.isPalindrome("racecar"));
    }

    @Test
    void testIsPalindromeWithNonPalindrome() {
        // Test case for an empty string
        assertTrue(PalindromeChecker.isPalindrome(""));
    }

    @Test
    void TestPalindromeWithMixedCase() {
        // Test case for a string with mixed case letters
        assertTrue(PalindromeChecker.isPalindrome("RaceCar"));
    }


}
