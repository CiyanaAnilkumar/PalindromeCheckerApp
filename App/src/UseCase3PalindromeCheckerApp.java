//version 3.0
//author Ciyana
//useCase 3:
public class UseCase3PalindromeCheckerApp {
    public static void main(String[] args) {
        String original = "racecar";
        String reversed = "";
        for (int i = original.length() - 1; i >= 0; i--) {
            reversed = reversed + original.charAt(i);
        }
        System.out.println("Original String : " + original);
        System.out.println("Reversed String : " + reversed);
        if (original.equals(reversed)) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }
        System.out.println("Program executed successfully.");
    }
}
