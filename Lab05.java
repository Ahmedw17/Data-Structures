import java.util.Scanner;
import java.util.Stack;
public class Lab05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Please enter an expression with parentheses:");
        String expression = input.nextLine();
        if (isBalanced(expression)) {
            System.out.println("Your expression is correct and balanced");
        } else {
            System.out.println("Your expression is not correct. Unbalanced parentheses");
        }
        System.out.println("\n-----------------------------------\n");
      
        int number = 0;
        boolean valid = false;
        while (!valid) {
            System.out.print("Enter a decimal number to convert to binary: ");
            String line = input.nextLine().trim();
            try {
                number = Integer.parseInt(line);
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer (e.g. 12, not 12.2).");
            }
        }
        System.out.print("Binary representation: ");
        decimalToBinary(number);
        System.out.println();
    }
   
    public static boolean isBalanced(String expr) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) return false;
                char last = stack.pop();
                if (!isMatchingPair(last, ch)) return false;
            }
        }
        return stack.isEmpty();
    }
    
    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '[' && close == ']') ||
               (open == '{' && close == '}');
    }
   
    public static void decimalToBinary(int number) {
        Stack<Integer> stack = new Stack<>();
        if (number == 0) {
            System.out.print(0);
            return;
        }
        while (number > 0) {
            int digit = number % 2;
            stack.push(digit);
            number = number / 2;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
