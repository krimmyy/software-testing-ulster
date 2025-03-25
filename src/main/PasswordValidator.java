package main;

import java.util.regex.Pattern;

public class PasswordValidator {
    private static final int MIN_LENGTH = 8;
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(
            "^(?=.*[0-9])" +     // At least one digit
            "(?=.*[a-z])" +      // At least one lowercase letter
            "(?=.*[A-Z])" +      // At least one uppercase letter
            "(?=.*[_#])" +       // At least one underscore or hash
            "(?=\\S+$)" +        // No spaces allowed
            ".{" + MIN_LENGTH + ",}$" // Minimum length
    );

    public static boolean isValidPassword(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    public static void main(String[] args) {
        String[] testPasswords = {
                "Weak123",       // Too short, no special characters
                "Strong#123",    // Missing underscore
                "Valid_#1A",     // Meets all criteria
                "NoDigits_#",    // Missing digits
                "with space_#1A" // Contains space
        };

        for(String password : testPasswords) {
            System.out.println(password + " -> " + (isValidPassword(password) ? "Valid" : "Invalid"));
        }
    }
}
