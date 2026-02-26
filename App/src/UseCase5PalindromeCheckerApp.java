//version 5.0
//author Ciyana
//useCase 5:
import java.util.Scanner;
import java.util.Stack;

public class UseCase5PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Stack-Based Palindrome Checker ---");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String cleanedInput = input.replaceAll("[^a-zA-Z0-String0-9]", "").toLowerCase();

        if (isPalindrome(cleanedInput)) {
            System.out.println("\"" + input + "\" is a palindrome.");
        } else {
            System.out.println("\"" + input + "\" is NOT a palindrome.");
        }

        scanner.close();
    }


    public static boolean isPalindrome(String text) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < text.length(); i++) {
            stack.push(text.charAt(i));
        }

        StringBuilder reversedText = new StringBuilder();
        while (!stack.isEmpty()) {
            reversedText.append(stack.pop());
        }

        return text.equals(reversedText.toString());
    }
}
