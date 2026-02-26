//version 11.0
//author Ciyana
//useCase 11:
import java.util.Scanner;
class PalindromeService {
    public boolean checkPalindrome(String input) {
        if (input == null) return false;
        String cleaned = input.toLowerCase().replaceAll("[^a-z0-9]", "");

        if (cleaned.isEmpty()) return false;
        int start = 0;
        int end = cleaned.length() - 1;

        while (start < end) {
            if (cleaned.charAt(start) != cleaned.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
public class UseCase11PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PalindromeService service = new PalindromeService();

        System.out.println("--- Object-Oriented Palindrome Service ---");
        System.out.print("Enter your text: ");
        String userInput = scanner.nextLine();
        boolean result = service.checkPalindrome(userInput);

        if (result) {
            System.out.println("Result: The input is a valid palindrome.");
        } else {
            System.out.println("Result: The input is NOT a palindrome.");
        }

        scanner.close();
    }
}