package Week1;

public class PalindromeChecker {

    public static boolean isPalindrome(String s) {
        // Converting string to lowercase
        s = s.toLowerCase();

        // Reversing the string
        String rev = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            rev = rev + s.charAt(i);
        }

        // Comparing the original string with the reversed one
        return s.equals(rev);
    }

    public static void main(String[] args) {

        // Input string
        String s = "racecar";

        // Checking if the string is a palindrome
        boolean res = isPalindrome(s);

        // Print the result
        if (res) {
            System.out.println("\"" + s + "\" is a palindrome.");
        } else {
            System.out.println("\"" + s + "\" is not a palindrome.");
        }
    }

}
