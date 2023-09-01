import java.util.Arrays;
import java.util.Stack;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        System.out.println(Arrays.toString(tokens));
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < tokens.length) {
            if (isOperator(tokens[i])) {
                int n2 = stack.pop();
                int n1 = stack.pop();
                stack.push(calculate(n1, n2, tokens[i]));
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
            System.out.println(stack);
            i++;
        }
        return stack.pop();
    }

    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    private int calculate(int n1, int n2, String o) {
        return switch (o) {
            case "+" -> n1 + n2;
            case "-" -> n1 - n2;
            case "*" -> n1 * n2;
            case "/" -> n1 / n2;
            default -> 0;
        };
    }
}
