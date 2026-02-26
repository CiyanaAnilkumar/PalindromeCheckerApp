//version 12.0
//author Ciyana
//useCase 12:
import java.util.*;
interface PalindromeStrategy {
    boolean isValid(String text);
}
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isValid(String text) {
        String clean = text.toLowerCase().replaceAll("[^a-z0-0]", "");
        Stack<Character> stack = new Stack<>();
        for (char c : clean.toCharArray()) stack.push(c);

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) reversed.append(stack.pop());

        return clean.equals(reversed.toString());
    }
}
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean isValid(String text) {
        String clean = text.toLowerCase().replaceAll("[^a-z0-9]", "");
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : clean.toCharArray()) deque.addLast(c);

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) return false;
        }
        return true;
    }
}
class PalindromeContext {
    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeStrategy(String text) {
        if (strategy == null) return false;
        return strategy.isValid(text);
    }
}
public class UseCase12PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PalindromeContext context = new PalindromeContext();

        System.out.println("--- Strategy Pattern Palindrome Checker ---");
        System.out.print("Enter text: ");
        String input = scanner.nextLine();

        System.out.println("Select Strategy: 1) Stack  2) Deque");
        int choice = scanner.nextInt();

        if (choice == 1) {
            context.setStrategy(new StackStrategy());
            System.out.println("Using Stack Strategy...");
        } else {
            context.setStrategy(new DequeStrategy());
            System.out.println("Using Deque Strategy...");
        }

        if (context.executeStrategy(input)) {
            System.out.println("Result: It's a palindrome!");
        } else {
            System.out.println("Result: Not a palindrome.");
        }

        scanner.close();
    }
}