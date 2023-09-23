package recursion;

import java.util.HashMap;
import java.util.Map;

public class Fibo {


    public static int fibo(int n) {
        if (n < 2) {
            return n;
        }
        return fibo(n - 1) + fibo(n - 2);
    }


    private static final Map<Integer, Integer> mem = new HashMap<>();
    public static int fiboDP(int n) {
        if (n < 2) {
            return n;
        }

        if (mem.containsKey(n)) {
            return mem.get(n);
        }

        mem.put(n, fiboDP(n - 1) + fiboDP(n - 2));
        return mem.get(n);
    }

    public static void main(String[] args) {
        int n = 6;
        System.out.println("Fibo of " + n + " is " + fibo(n));
        System.out.println("Fibo of " + n + " is " + fiboDP(n));
    }

}
