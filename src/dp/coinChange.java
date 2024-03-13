package dp;

import java.util.Arrays;

public class coinChange {

    /** UNBOUNDED KNAPSACK PROBLEM **/
    public static int coinChanges(int[] coins, int amount) {
        int maxAmount = amount + 1;
        int[] dp = new int[maxAmount];
        Arrays.fill(dp, maxAmount);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    // Count of remaining dp[i - coin] and +1 for the current coin
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChanges(coins, amount));
    }


}
