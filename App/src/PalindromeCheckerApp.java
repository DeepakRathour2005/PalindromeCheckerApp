/**
 * ============================================================
 * MAIN CLASS - UseCase3PalindromeCheckerApp
 * ============================================================
 * Use Case 3: Palindrome Check Using String Reverse
 */

public class UseCase3PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "madam";
        String reversed = "";

        // Reverse the string using loop
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed = reversed + input.charAt(i);
        }

        boolean isPalindrome = input.equals(reversed);

        System.out.println("Input text: " + input);
        System.out.println("Reversed text: " + reversed);
        System.out.println("Is it a Palindrome?: " + isPalindrome);
    }
}