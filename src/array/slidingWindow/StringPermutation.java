package array.slidingWindow;

public class StringPermutation {

    private static boolean areArraysEqual(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }

        return true;
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;

        int[] freqS1 = new int[26];
        for (char c : s1.toCharArray()) {
            freqS1[c - 'a']++;
        }

        int[] freqS2 = new int[26];
        int start = 0, end = 0;

        while (end < s2.length()) {
            freqS2[s2.charAt(end) - 'a']++;

            // Window size - end - start + 1
            if (end - start + 1 == s1.length()) {
                if (areArraysEqual(freqS1, freqS2)) {
                    return true;
                }
            }

            if (end - start + 1 < s1.length()) {
                end++;
            } else {
                freqS2[s2.charAt(start) - 'a']--;
                start++;
                end++;
            }

        }
        return false;
    }

    /* -----------------------------------------------------------------------------------------------*/

    private static boolean allZero(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }

    public static boolean checkInclusion2(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;

        int[] count = new int[26];

        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }

        if (allZero(count)) {
            return true;
        }

        for (int j = len1; j < len2; j++) {
            count[s2.charAt(j) - 'a']--;
            count[s2.charAt(j - len1) - 'a']++;

            if (allZero(count)) {
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        String s1 = "ab", s2 = "dbao";
        System.out.println(checkInclusion(s1, s2));
        System.out.println(checkInclusion2(s1, s2));
    }

}
