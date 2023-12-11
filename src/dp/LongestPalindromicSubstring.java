package dp;

public class LongestPalindromicSubstring {
    static int low = 0;
    static int high = 0;

    static String longestPalindrome(String s) {
        if (s.length() < 2) return s;

        for (int i = 0; i < s.length() - 1; i++) {
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i + 1);
        }
        return s.substring(low, low + high);
    }

    static void extendPalindrome(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        if (high < j - i - 1) {
            low = i + 1;
            high = j - i - 1;
        }
    }


    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

}
