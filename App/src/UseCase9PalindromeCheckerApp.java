//version 9.0
//author Ciyana
//useCase 9:
import java.util.Scanner;

public class UseCase9PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Recursive Palindrome Checker ---");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        String cleanedInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        if (isPalindromeRecursive(cleanedInput, 0, cleanedInput.length() - 1)) {
            System.out.println("Result: \"" + input + "\" is a palindrome.");
        } else {
            System.out.println("Result: \"" + input + "\" is NOT a palindrome.");
        }

        scanner.close();
    }
    public static boolean isPalindromeRecursive(String text, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (text.charAt(left) != text.charAt(right)) {
            return false;
        }
        return isPalindromeRecursive(text, left + 1, right - 1);
    }
}