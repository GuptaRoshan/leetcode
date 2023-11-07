package backtrack;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    public static List<String> letterCasePermutationDFS(String s) {
        List<String> result = new ArrayList<>();

        if (s.length() == 0) return result;
        helper2(result, s.toCharArray(), 0);

        return result;
    }

    public static void helper2(List<String> result, char[] ch, int pos) {
        if (ch.length == pos) {
            result.add(String.valueOf(ch));
        } else {
            if (Character.isLetter(ch[pos])) {

                ch[pos] = Character.toLowerCase(ch[pos]);
                helper2(result, ch, pos + 1);

                ch[pos] = Character.toUpperCase(ch[pos]);
                helper(result, ch, pos + 1);
            } else {
                helper2(result, ch, pos + 1);
            }

        }
    }


    public static void helper(List<String> result, char[] ch, int pos) {
        if (ch.length == pos) {
            result.add(String.valueOf(ch));
            return;
        }

        if (Character.isDigit(ch[pos])) {
            helper(result, ch, pos + 1);
            return;
        }

        ch[pos] = Character.toLowerCase(ch[pos]);
        helper(result, ch, pos + 1);

        ch[pos] = Character.toUpperCase(ch[pos]);
        helper(result, ch, pos + 1);
    }

    public static void main(String[] args) {
        String s = "a1b2";
        System.out.println(letterCasePermutationDFS(s));
    }

}
