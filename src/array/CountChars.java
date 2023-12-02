package array;

public class CountChars {

    public static String countChars(String value) {
        int start = 0;
        int curr = 0;
        int count = 0;
        String result = "";

        while (curr < value.length()) {
            if (value.charAt(start) == value.charAt(curr)) {
                curr++;
                count++;
            } else {
                result += value.charAt(start) + String.valueOf(count);
                start = curr;
                count = 0;
            }

            if (curr == value.length()) {
                result += value.charAt(start) + String.valueOf(count);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        String string1 = "aaa";
        String string2 = "aaabbc";
        System.out.println(countChars(string1));
        System.out.println(countChars(string2));
    }
}
