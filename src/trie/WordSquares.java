package trie;

import java.util.*;

public class WordSquares {
    /**
     * 425. Word Squares
     * Given a set of words (without duplicates), find all word squares you can build from them.
     * A sequence of words forms a valid word square if the kth row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).
     * <p>
     * Input:
     * ["area","lead","wall","lady","ball"]
     * <p>
     * Output:
     * [ ["wall",
     * "area",
     * "lead",
     * "lady"],
     * <p>
     * [ "ball",
     * "area",
     * "lead",
     * "lady"]
     * ]
     * <p>
     * Explanation:
     * The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
     **/

    static Map<String, List<String>> map = new HashMap<>();

    public static List<List<String>> wordSquare(String[] words) {
        List<List<String>> result = new ArrayList<>();
        createPrefixMap(words);
        for (String word : words) {
            LinkedList<String> list = new LinkedList<>();
            list.add(word);
            backtrack(1, list, result, word.length());
        }
        return result;
    }

    public static void backtrack(int step, LinkedList<String> list, List<List<String>> result, int n) {
        if (list.size() == n) {
            result.add(new ArrayList<>(list));
            return;
        }

        // This loop selects common character from the list of all words
        // b  a  l  l
        // a  r  e  a
        // l  e
        // l  a
        // Example : [ball, area], we need next word with le - prefix
        StringBuilder sb = new StringBuilder();
        for (String word : list) {
            sb.append(word.charAt(step));
        }

        String prefix = sb.toString();
        List<String> wordList = map.getOrDefault(prefix, new ArrayList<>());
        for (String word : wordList) {
            list.add(word);
            backtrack(step + 1, list, result, n);
            list.removeLast();
        }
    }

    public static void createPrefixMap(String[] words) {
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                String prefix = word.substring(0, i);
                map.computeIfAbsent(prefix, k -> new ArrayList<>()).add(word);
            }
        }
        //{=[area, lead, wall, lady, ball], a=[area], b=[ball], wal=[wall], lea=[lead], wa=[wall], l=[lead, lady],
        // bal=[ball], lad=[lady], ar=[area], are=[area], la=[lady], w=[wall], le=[lead], ba=[ball]}
        System.out.println(map.toString());
    }

    public static void main(String[] args) {
        String[] words = new String[]{"area", "lead", "wall", "lady", "ball"};
       wordSquare(words);
    }

}
