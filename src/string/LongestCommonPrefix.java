package string;

import java.util.Arrays;

class LongestCommonPrefix {

    public static String commonPrefix(String[] strings) {
        int count = 0;
        Arrays.sort(strings);
        String first = strings[0];
        String last = strings[strings.length - 1];

        while (count < first.length()) {
            if (first.charAt(count) == last.charAt(count)) {
                count++;
            } else {
                break;
            }
        }
        return count == 0 ? "" : first.substring(0, count);
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"flower", "flow", "flight"};
        System.out.println(commonPrefix(strings));
    }
}