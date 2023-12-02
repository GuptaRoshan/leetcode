package dp;

public class EggDropProblem {

    public static int eggDrop(int eggs, int floors) {
        // Create a 2D array to store the minimum attempts for each subproblem
        int[][] dp = new int[eggs + 1][floors + 1];

        // Base cases: If there is only one egg, we need to try all floors one by one
        for (int i = 1; i <= floors; i++) {
            dp[1][i] = i;
        }

        // Fill the DP table for the remaining eggs and floors
        for (int egg = 2; egg <= eggs; egg++) {
            for (int floor = 1; floor <= floors; floor++) {
                dp[egg][floor] = Integer.MAX_VALUE;
                for (int k = 1; k <= floor; k++) {
                    // Calculate the minimum attempts for the worst-case scenario
                    int attempts = 1 + Math.max(dp[egg - 1][k - 1], dp[egg][floor - k]);
                    // Update the minimum attempts if the current attempt is better
                    dp[egg][floor] = Math.min(dp[egg][floor], attempts);
                }
            }
        }

        // The result is stored in the bottom-right corner of the DP table
        return dp[eggs][floors];
    }

    public static void main(String[] args) {
        int eggs = 2;
        int floors = 10;

        int minAttempts = eggDrop(eggs, floors);
        System.out.println("Minimum attempts needed: " + minAttempts);
    }
}
