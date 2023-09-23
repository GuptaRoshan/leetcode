package recursion;

import java.util.HashMap;
import java.util.Map;

public class Factorial {

    private static final Map<Integer, Integer> mem = new HashMap<>();

    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static int factorialDP(int n) {
        if (n <= 1) {
            return 1;
        }

        if (mem.containsKey(n)) {
            return mem.get(n);
        }

        mem.put(n, n * factorial(n - 1));
        return mem.get(n);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Factorial of " + n + " is " + factorial(n));
        System.out.println("Factorial of " + n + " is " + factorialDP(n));
    }

}
