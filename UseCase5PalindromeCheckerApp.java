import java.util.Scanner;
import java.util.Stack;

public class UseCase5PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to check if it's a palindrome:");
        
        String input = scanner.nextLine();
        
        if (input == null || input.isEmpty()) {
            System.out.println("\"\" is a Palindrome.");
            scanner.close();
            return;
        }

        // Clean input for strict alphanumeric palindrome check (standard practice)
        String cleanedInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        Stack<Character> stack = new Stack<>();
        
        // Push characters into stack
        for (int i = 0; i < cleanedInput.length(); i++) {
            stack.push(cleanedInput.charAt(i));
        }
        
        // Pop and build the reversed string
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        
        // Compare result
        if (cleanedInput.equals(reversed.toString())) {
            System.out.println("\"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("\"" + input + "\" is NOT a Palindrome.");
        }
        
        scanner.close();
    }
}
