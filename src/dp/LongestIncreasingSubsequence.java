package dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    /**
     * Bottom-up DP using tabulation
     * Video Link : <a href="https://www.youtube.com/watch?v=Xq3hlMvhrkE&t=11s&ab_channel=NikhilLohia">...</a>
     **/

    public static int lengthOfLongestIncreasingSequence(int[] number) {
        int ans = 1, n = number.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++)
            for (int j = 0; j < i; j++)
                if (number[i] > number[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    ans = Math.max(ans, dp[i]);
                }
        return ans;
    }

    public static void main(String[] args) {
        int[] number = {1, 2, 3, 4, 5, 6, 30, 8, 9, 2};
        System.out.println(lengthOfLongestIncreasingSequence(number));
    }
}
