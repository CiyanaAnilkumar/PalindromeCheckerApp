//version 7.0
//author Ciyana
//useCase 7:
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class UseCase7PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Deque-Based Optimized Palindrome Checker ---");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        String cleanedInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (isPalindrome(cleanedInput)) {
            System.out.println("Result: \"" + input + "\" is a palindrome.");
        } else {
            System.out.println("Result: \"" + input + "\" is NOT a palindrome.");
        }

        scanner.close();
    }


    public static boolean isPalindrome(String text) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : text.toCharArray()) {
            deque.addLast(ch);
        }
        while (deque.size() > 1) {
            Character front = deque.removeFirst();
            Character rear = deque.removeLast();

            if (!front.equals(rear)) {
                return false;
            }
        }

        return true;
    }
}