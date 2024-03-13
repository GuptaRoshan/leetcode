package dp;

import java.util.*;

public class WordBreak {

    public static boolean DP1(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {

                String sub = s.substring(j, i);
                System.out.println(sub);

                dp[i] = dp[j] && set.contains(sub);

                //dp[i] = dp[j] && set.contains(sub);

                if (dp[i]) break;
            }
        }

        return dp[s.length()];
    }


    public static boolean DP2(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (String str : wordDict) {
                if (str.length() <= i) {
                    if (dp[i - str.length()]) {
                        if (s.startsWith(str, i - str.length())) {
                            dp[i] = true;
                            break;
                        }
                    }
                }
            }
        }

        return dp[s.length()];
    }


    public static boolean helper(String s, Set set) {
        if (s.length() == 0) {
            return true;
        }

        for (int i = 1; i <= s.length(); i++) {
            if (set.contains(s.substring(0, i))  &&  helper(s.substring(i), set) ) {
                return true;
            }
        }

        return false;
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        return helper(s, set);
    }


    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>(Arrays.asList("leet", "code"));
        System.out.println(wordBreak(s, wordDict));

    }
}


