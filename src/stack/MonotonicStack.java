package stack;

import java.util.Stack;

public class MonotonicStack {

    public static void main(String[] args) {

        int[] elements = {6, 2, 7, 9};
        Stack<Integer> stack = new Stack<>();

        for (Integer currentElement : elements) {
            while (!stack.isEmpty() && stack.peek() < currentElement) {
                stack.pop();
            }
            stack.push(currentElement);
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }
}
