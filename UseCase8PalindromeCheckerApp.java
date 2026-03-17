import java.util.Scanner;

public class UseCase8PalindromeCheckerApp {

    // Node class for singly linked list
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    // Build linked list from string
    static Node buildLinkedList(String s) {
        Node head = null, tail = null;
        for (int i = 0; i < s.length(); i++) {
            Node newNode = new Node(s.charAt(i));
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        return head;
    }

    // Find middle using fast & slow pointer technique
    static Node findMiddle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Reverse second half of linked list in-place
    static Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to check if it's a palindrome:");

        String input = scanner.nextLine();
        scanner.close();

        if (input == null || input.isEmpty()) {
            System.out.println("\"\" is a Palindrome.");
            return;
        }

        // Clean input
        String cleanedInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (cleanedInput.length() <= 1) {
            System.out.println("\"" + input + "\" is a Palindrome.");
            return;
        }

        // Step 1: Convert string to linked list
        Node head = buildLinkedList(cleanedInput);

        // Step 2: Find the middle node
        Node middle = findMiddle(head);

        // Step 3: Reverse the second half
        Node secondHalfHead = reverseList(middle.next);

        // Step 4: Compare first half and reversed second half
        Node p1 = head;
        Node p2 = secondHalfHead;
        boolean isPalindrome = true;

        while (p2 != null) {
            if (p1.data != p2.data) {
                isPalindrome = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // Print result
        if (isPalindrome) {
            System.out.println("\"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("\"" + input + "\" is NOT a Palindrome.");
        }
    }
}
