package dp;

// Different problems : https://leetcode.com/discuss/study-guide/4861127/LCS-and-its-patterns-(10-similar-question)
public class LongestCommonSubsequence {

    // Video Link : https://www.youtube.com/watch?v=e9tUPwZZSBI&ab_channel=NikhilLohia
    public static int findLCSLength(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        // Build the DP table
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    // Summing Diagonal cell with 1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // Max of Top or Left cell in matrix
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        //output should be 4 (BDAB)
        String str1 = "ABCBDAB";
        String str2 = "BDCAB";
        int length = findLCSLength(str1, str2);
        System.out.println("Length of Longest Common Subsequence: " + length);
    }
}
