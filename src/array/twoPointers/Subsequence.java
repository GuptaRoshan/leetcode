package array.twoPointers;

public class Subsequence {

    public static boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        int sLength = s.length();
        int tLength = t.length();
        while (i < sLength && j < tLength) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == sLength;
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        isSubsequence(s, t);
    }

}




