package backtrack;

public class AllSubstring {

    private static void findSubstrings(String input, int start, String currentSubstring) {
        // Base case: if we have reached the end of the string
        if (start == input.length()) {
            System.out.println(currentSubstring);
            return;
        }
        // Include the current character in the substring
        findSubstrings(input, start + 1, currentSubstring + input.charAt(start));
        // Exclude the current character from the substring
        findSubstrings(input, start + 1, currentSubstring);
    }


    private static void findAllSubstrings_Recursion(String s) {
        if (s.isEmpty()) return;

        for (int i = 1; i <= s.length(); ++i) {
            System.out.println(s.substring(0, i));
            // Excludes s.substring(0, i)
            findAllSubstrings_Recursion(s.substring(i));
        }
    }

    public static void printSubstrings(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                System.out.println(str.substring(i, j));
            }
        }
    }



    public static void main(String[] args) {
        String input = "abc";
        //findAllSubstrings_Recursion(input);
        findSubstrings(input, 0, "");
        //printSubstrings(input);
    }

}
