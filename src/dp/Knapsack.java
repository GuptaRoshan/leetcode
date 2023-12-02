package dp;

public class Knapsack {

    public static int knapsack01(int[] values, int[] weights, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int w = 0; w <= n; w++) {
            for (int c = 0; c <= capacity; c++) {

                if (w == 0 || c == 0) {
                    dp[w][c] = 0;

                } else if (weights[w - 1] <= c) {

                    // values[w - 1] -  Current value in array
                    int currentProfit = values[w - 1];
                    // dp[w - 1]  - previous row in matrix
                    int prevRow = w - 1;
                    // c - current capacity
                    int CurrentCapacity = c;
                    // weights[w - 1] - current weights in array
                    int currentWeight = values[w - 1];

                    dp[w][c] = Math.max(values[w - 1] + dp[w - 1][c - weights[w - 1]], dp[w - 1][c]);

                } else {
                    dp[w][c] = dp[w - 1][c];
                }

            }
        }
        return dp[n][capacity];
    }

    public static int unboundedKnapsack(int[] values, int[] weights, int capacity) {
        int n = weights.length;

        // Create an array to store the maximum value for each capacity
        int[] dp = new int[capacity + 1];

        // Fill the dp array using a bottom-up approach
        for (int c = 0; c <= capacity; c++) {
            for (int i = 0; i < n; i++) {
                if (weights[i] <= c) {
                    dp[c] = Math.max(dp[c], values[i] + dp[c - weights[i]]);
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

        int maxValue = knapsack01(values, weights, capacity);
        System.out.println("Maximum value that can be obtained: " + maxValue);

        maxValue = unboundedKnapsack(values, weights, capacity);
        System.out.println("Maximum value that can be obtained: " + maxValue);
        
    }

}
