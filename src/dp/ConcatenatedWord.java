package dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConcatenatedWord {
    static List<String> findAllConcatenatedWordsInADict(List<String> words) {
        Set<String> wordsSet = new HashSet<>(words);
        List<String> res = new ArrayList<>();
        for (String word : words) {
            int n = word.length();
            int[] dp = new int[n + 1];
            dp[0] = 1;
            for (int i = 0; i < n; i++) {
                if (dp[i] == 0) continue;
                for (int j = i + 1; j <= n; j++) {
                    if (j - i < n && wordsSet.contains(word.substring(i, j))) {
                        dp[j] = 1;
                    }
                }
                if (dp[n] == 1) {
                    res.add(word);
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("cat");
        words.add("cats");
        words.add("catsdogcats");
        words.add("dog");
        words.add("dogcatsdog");
        words.add("hippopotamuses");
        words.add("rat");
        List<String> result = findAllConcatenatedWordsInADict(words);
        System.out.println(result);
    }
}
