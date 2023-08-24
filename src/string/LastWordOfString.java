package string;

public class LastWordOfString {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("a"));
    }

    public static int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        for (int i = words.length - 1; i > 0; i--) {
            if (!words[i].isEmpty()) {
                return words[i].length();
            }
        }
        return 0;
    }
}
