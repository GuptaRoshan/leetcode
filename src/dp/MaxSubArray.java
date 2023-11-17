package dp;

public class MaxSubArray {
    public static int maxSubArray(int[] A) {
        int n = A.length;
        int[] dp = new int[n];
        dp[0] = A[0];
        int max = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(A[i] + dp[i - 1], A[i]);
            max = Math.max(max, dp[i]);
        }

        return max;
    }


    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(maxSubArray(nums));
    }

}
