package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LIS {


    //---Longest Increasing Subsequence using binary search--
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (result.size() == 0 || nums[i] > result.get(result.size() - 1)) {
                result.add(nums[i]);
            } else {
                int index = binarySearch(result, nums[i]);
                result.set(index, nums[i]);
            }
        }

        return result.size();
    }

    public static int binarySearch(List<Integer> result, int x) {
        int left = 0;
        int right = result.size() - 1;
        int index = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (result.get(mid) >= x) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }


    //---Longest Increasing Subsequence using DP--
    public static int lengthOfLIS_DP(int[] nums) {
        int ans = 1, n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++)
            for (int j = 0; j < i; j++)

                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    ans = Math.max(ans, dp[i]);
                }
        return ans;
    }


    //---Longest Increasing Subsequence using recursion--
    static int lengthOfLIS_Recursion(int[] nums) {
        return solve(nums, 0, Integer.MIN_VALUE);
    }

    static int solve(int[] nums, int i, int prev) {
        if (i >= nums.length) return 0;
        int take = 0;
        int dontTake = solve(nums, i + 1, prev);
        if (nums[i] > prev){
            take = 1 + solve(nums, i + 1, nums[i]);
        }
        return Math.max(take, dontTake);
    }


    public static void main(String[] args) {
        int[] num = {1, 2};
        System.out.println(lengthOfLIS_Recursion(num));
    }
}
