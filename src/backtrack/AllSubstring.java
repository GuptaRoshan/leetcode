package backtrack;

public class AllSubstring {


    // Function to find all substrings of a given string
    public static void findAllSubstrings(String input) {
        findSubstrings(input, 0, "");
    }

    private static void findSubstrings(String input, int start, String currentSubstring) {
        //int n = input.length();

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

        if (s.length() == 0) {
            return;
        }

        for (int i = 1; i <= s.length(); ++i) {
            System.out.println(s.substring(0, i));
            findAllSubstrings_Recursion(s.substring(i));
        }

    }


    public static void main(String[] args) {
        String input = "abc";
        findAllSubstrings_Recursion(input);
        //findAllSubstrings(input);
    }

}
