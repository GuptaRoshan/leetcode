package backtrack;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumber {

    private static final String[] keyboard = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};


    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits.isEmpty() || digits == null) {
            return result;
        }

        helper(digits, "", 0, result);
        return result;
    }

    public static void helper(String digits, String prefix, int offset, List<String> result) {
        if (offset >= digits.length()) {
            result.add(prefix);
            return;
        }

        String letters = keyboard[digits.charAt(offset) - '0'];

        for (int i = 0; i < letters.length(); i++) {
            helper(digits, prefix + letters.charAt(i), offset + 1, result);
        }

    }

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }

}
