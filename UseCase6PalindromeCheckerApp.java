import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class UseCase6PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to check if it's a palindrome:");
        
        String input = scanner.nextLine();
        
        if (input == null || input.isEmpty()) {
            System.out.println("\"\" is a Palindrome.");
            scanner.close();
            return;
        }

        // Clean input for strict alphanumeric palindrome check
        String cleanedInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        
        // Push characters into stack and enqueue into queue
        for (int i = 0; i < cleanedInput.length(); i++) {
            char c = cleanedInput.charAt(i);
            stack.push(c);
            queue.add(c);
        }
        
        // Compare dequeue vs pop
        boolean isPalindrome = true;
        while (!stack.isEmpty() && !queue.isEmpty()) {
            char fromStack = stack.pop();
            char fromQueue = queue.remove();
            
            if (fromStack != fromQueue) {
                isPalindrome = false;
                break;
            }
        }
        
        // Print result
        if (isPalindrome) {
            System.out.println("\"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("\"" + input + "\" is NOT a Palindrome.");
        }
        
        scanner.close();
    }
}
