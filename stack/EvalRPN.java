import java.util.ArrayDeque;
import java.util.Deque;

public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Deque<Integer> q = new ArrayDeque<>();

        for (String s : tokens) {
            if (isNumeric(s)) {
                q.push(Integer.parseInt(s));
            } else if (isOperator(s)) {
                int c = q.pop();
                int b = q.pop();
                int a = 0;
                if (s.equalsIgnoreCase("+")) {
                    a = b + c;
                } else if (s.equalsIgnoreCase("-")) {
                    a = b - c;
                } else if (s.equalsIgnoreCase("*")) {
                    a = b * c;
                } else if (s.equalsIgnoreCase("/")) {
                    a = b / c;
                }
                q.push(a);
            }
        }
        return q.peek();
    }

    public static void main(String[] args) {

    }

    // Checks for positive, negative, and decimal numbers
    public static boolean isNumeric(String str) {
        if (str == null || str.isEmpty())
            return false;
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    // Checks for standard mathematical operators
    public static boolean isOperator(String str) {
        if (str == null || str.isEmpty())
            return false;
        // Matches exactly one character from the set: +, -, *, /, or %
        return str.matches("[+\\-*/%]");
    }
}
