package array.slidingWindow;

public class LongestCharReplacement {

    public static int characterReplacement(String s, int k) {
        int[] charCount = new int[127];
        int start = 0, end = 0;
        int maxCount = 0;
        int maxLen = 0;
        while (end < s.length()) {
            maxCount = Math.max(maxCount, ++charCount[s.charAt(end)]);
            if (end - start + 1 - maxCount > k) {
                charCount[s.charAt(start)]--;
                start++;
            }

            maxLen = Math.max(maxLen, end - start + 1);
            end++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement(s, k));
    }
}
