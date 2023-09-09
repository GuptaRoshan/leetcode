package array;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {
    public static int climbStairsMemo(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return climbStairsMemo(n, memo);
    }

    public static int climbStairsMemo(int n, Map<Integer, Integer> memo) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (!memo.containsKey(n)) {
            memo.put(n, climbStairsMemo(n - 1, memo) + climbStairsMemo(n - 2, memo));
        }
        return memo.get(n);
    }

    public static int climbStairsTabulation(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairsMemo(5));
        System.out.println(climbStairsTabulation(5));
    }

}
