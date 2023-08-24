package string;

public class FirstOccurrence {
    public static void main(String[] args) {
        System.out.println(strStr("a", "a"));

    }

    public static int strStr(String haystack, String needle) {
        int nSize = needle.length();
        int found = -1;
        for (int i = 0; i < haystack.length() - nSize; i++) {
            if (haystack.substring(i, i + nSize).equals(needle)) {
                found = i;
                break;
            }

        }
        return found;

    }

}
