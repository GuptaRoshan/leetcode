package backtrack;

import java.util.ArrayList;
import java.util.List;

public class palindromicPartitioning {

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        helper(s, result, new ArrayList<String>());
        return result;
    }

    public static void helper(String s, List<List<String>> result, List<String> temp) {
        if (s == null || s.length() == 0) {
            result.add(new ArrayList<>(temp));
        }

        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(0, i + 1);

            if (!isPalindrome(sub)) continue;
            temp.add(sub);

            helper(s.substring(i + 1), result, temp);
            temp.remove(temp.size() - 1); // unchoose
        }
    }

    public static void main(String[] args) {
        String s = "ab";
        System.out.println(partition(s));
    }
}
