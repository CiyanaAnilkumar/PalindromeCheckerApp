//version 10.0
//author Ciyana
//useCase 10:
import java.util.Scanner;

public class UseCase10PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Case-Insensitive & Space-Ignored Palindrome Checker ---");
        System.out.print("Enter a phrase: ");
        String input = scanner.nextLine();
        String normalized = input.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        if (normalized.isEmpty()) {
            System.out.println("Error: No alphanumeric characters found to check.");
        } else if (isPalindrome(normalized)) {
            System.out.println("Success! After normalizing to \"" + normalized + "\", it IS a palindrome.");
        } else {
            System.out.println("Result: After normalizing to \"" + normalized + "\", it is NOT a palindrome.");
        }

        scanner.close();
    }
    public static boolean isPalindrome(String text) {
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}