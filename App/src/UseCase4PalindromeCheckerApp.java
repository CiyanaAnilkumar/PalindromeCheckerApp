//version 4.0
//author Ciyana
//useCase 4:
import java.util.Scanner;

public class UseCase4PalindromeCheckerApp {
    public static boolean isPalindromeUsingCharArray(String input) {

        char[] characters = input.toCharArray();

        int start = 0;
        int end = characters.length - 1;

        while (start < end) {

            if (characters[start] != characters[end]) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== UC4: Character Array Based Palindrome Check =====");
        System.out.print("Enter a string: ");

        String input = scanner.nextLine();

        input = input.replaceAll("\\s+", "").toLowerCase();

        boolean result = isPalindromeUsingCharArray(input);

        if (result) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}