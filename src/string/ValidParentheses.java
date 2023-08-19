package string;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println("Invalid String :" + isValid("(]"));
        System.out.println("Valid String :" + isValid("()[]{}"));
    }

    public static boolean isValid(String s) {
        if (s.isEmpty() || s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        // First Solution
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '{') {
                stack.push('}');
            } else if (ch == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != ch) {
                return false;
            }
        }

        // Second Solution
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.peek() == '(' && ch == ')' || stack.peek() == '[' && ch == ']' || stack.peek() == '{' && ch == '}') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
