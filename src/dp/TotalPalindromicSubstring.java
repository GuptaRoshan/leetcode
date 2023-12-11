package dp;

public class TotalPalindromicSubstring {

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

    public static int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                if (isPalindrome(sub)) {
                    count = count + 1;
                }
            }
        }
        return count;
    }

    //--------------- countSubstrings_extractPalindrome -------------------------
    public static int countSubstrings_extractPalindrome(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += extractPalindrome(s, i, i);//odd length
            count += extractPalindrome(s, i, i + 1);//even length
        }
        return count;
    }

    public static int extractPalindrome(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && (s.charAt(left) == s.charAt(right))) {
            left--;
            right++;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(countSubstrings_extractPalindrome(s));
    }

}
