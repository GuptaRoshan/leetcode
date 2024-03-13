package dp;

public class UnboundedKnapsack {

    public static int unboundedKnapsack(int[] values, int[] knapsack, int capacity) {
        int n = knapsack.length;
        // Create an array to store the maximum value for each capacity
        int[] dp = new int[capacity + 1];
        // Fill the dp array using a bottom-up approach
        for (int c = 0; c <= capacity; c++) {
            for (int i = 0; i < n; i++) {
                if (knapsack[i] <= c) {
                    dp[c] = Math.max(dp[c], values[i] + dp[c - knapsack[i]]);
                }
            }
        }
        // The final result is stored in the last element of the dp array
        return dp[capacity];
    }


    public static void main(String[] args) {
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int capacity = 50;
        int maxValue = unboundedKnapsack(values, weights, capacity);
        System.out.println("Maximum value that can be obtained: " + maxValue);
    }

}
