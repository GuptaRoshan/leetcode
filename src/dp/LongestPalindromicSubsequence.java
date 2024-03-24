package dp;

public class LongestPalindromicSubsequence {

    /**
     * @param s string
     * @return palindrome string
     */
    public static String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        // To store the states of the substring
        boolean[][] dp = new boolean[s.length()][s.length()];
        int maxLen = 1;
        int start = 0;
        int end = 0;

        // Set diagonal elements to true
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // If char at j and i are same then check  substring between j and i is palindrome or not from dp table dp[j + 1][i - 1])
                if (s.charAt(j) == s.charAt(i) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    // Window size for i and j, including both char at (i and j) example if string is "abc"
                    // If i = 0 and j = 2, then window size is 3 and substring is "abc"
                    if (i - j + 1 > maxLen) {
                        maxLen = j - i + 1;
                        start = j;
                        end = i;
                    }
                }
            }
        }

        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        String str = "bb";
        System.out.println(longestPalindrome(str));
    }
}
