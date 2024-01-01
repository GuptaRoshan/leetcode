package dp;

import java.util.Arrays;

public class HouseRobber {
    static int[] memo;

    public static int rob(int[] nums) {
        memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        return rob(nums, nums.length - 1);
    }

    private static int rob(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        if (memo[i] >= 0) {
            return memo[i];
        }
        int result = Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
        memo[i] = result;
        return result;
    }

    public static int robIterative(int[] num) {

        if (num.length == 0) {
            return 0;
        }

        int len = num.length + 1;
        int[] dp = new int[len];
        dp[0] = 0;
        dp[1] = num[0];

        for (int i = 2; i < len; i++) {
            int currLoot = num[i - 1];
            dp[i] = Math.max(dp[i - 2] + currLoot, dp[i - 1]);
        }

        return dp[dp.length - 1];
    }

    public static int rob2Helper(int[] num) {
        int val0 = num[0];
        num[0] = 0;
        int max1 = robIterative(num);
        num[0] = val0;
        num[num.length - 1] = 0;
        int max2 = robIterative(num);
        return Math.max(max1, max2);
    }

    public static void main(String[] args) {
        int[] nums = {3, 2};
        System.out.println(robIterative(nums));
    }
}
