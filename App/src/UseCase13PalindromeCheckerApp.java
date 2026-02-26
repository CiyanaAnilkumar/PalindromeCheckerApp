//version 13.0
//author Ciyana
//useCase 13:
import java.util.*;

public class UseCase13PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Palindrome Algorithm Performance Benchmark ---");
        System.out.print("Enter a string (use a long string for better results): ");
        String input = scanner.nextLine();
        String cleaned = input.toLowerCase().replaceAll("[^a-z0-9]", "");

        if (cleaned.isEmpty()) {
            System.out.println("Invalid input.");
            return;
        }

        System.out.println("\nResults (Time in Nanoseconds):");
        System.out.println("---------------------------------------------");

        benchmark("Two-Pointer (Iterative)", () -> isPalindromeTwoPointer(cleaned));
        benchmark("Stack-Based (LIFO)", () -> isPalindromeStack(cleaned));
        benchmark("Recursive Approach", () -> isPalindromeRecursive(cleaned, 0, cleaned.length() - 1));
        benchmark("Deque-Based", () -> isPalindromeDeque(cleaned));

        System.out.println("---------------------------------------------");
        scanner.close();
    }

    @FunctionalInterface
    interface PalindromeMethod {
        boolean run();
    }

    private static void benchmark(String name, PalindromeMethod method) {
        long startTime = System.nanoTime();
        boolean result = method.run();
        long endTime = System.nanoTime();

        long duration = endTime - startTime;
        System.out.printf("%-25s : %10d ns | Palindrome: %s%n", name, duration, result);
    }

    public static boolean isPalindromeTwoPointer(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }

    public static boolean isPalindromeStack(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) stack.push(c);
        for (char c : s.toCharArray()) {
            if (c != stack.pop()) return false;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String s, int left, int right) {
        if (left >= right) return true;
        if (s.charAt(left) != s.charAt(right)) return false;
        return isPalindromeRecursive(s, left + 1, right - 1);
    }

    public static boolean isPalindromeDeque(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()) deque.addLast(c);
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) return false;
        }
        return true;
    }
}