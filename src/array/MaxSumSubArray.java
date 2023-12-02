package array;

public class MaxSumSubArray {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int n = nums.length + 1;
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = nums[0];
        int max = Math.max(dp[0], dp[1]);

        for (int i = 1; i < nums.length; i++) {
            dp[i + 1] = Math.max(nums[i], dp[i] + nums[i]);
            max = Math.max(max, dp[i + 1]);
        }

        System.out.println(max);
    }
}
