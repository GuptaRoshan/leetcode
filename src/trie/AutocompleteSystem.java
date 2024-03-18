package trie;


import java.util.List;

public class AutocompleteSystem {
    // Solution : https://aaronice.gitbook.io/lintcode/data_structure/design-search-autocomplete-system

    /**
     * Input :
     * <p>
     * ["AutocompleteSystem", "input", "input", "input", "input"]
     * [[["i love you", "island", "ironman", "i love leetcode"], [5, 3, 2, 2]], ["i"], [" "], ["a"], ["#"]]
     * <p>
     * Output :
     * <p>
     * [null, ["i love you", "island", "i love leetcode"], ["i love you", "i love leetcode"], [], []]
     * <p>
     * Explanation :
     * <p>
     * AutocompleteSystem obj = new AutocompleteSystem(["i love you", "island", "iroman", "i love leetcode"], [5, 3, 2, 2]);
     * obj.input("i"); // return ["i love you", "island", "i love leetcode"]. There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree. Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman". Also we only need to output top 3 hot sentences, so "ironman" will be ignored.
     * obj.input(" "); // return ["i love you", "i love leetcode"]. There are only two sentences that have prefix "i ".
     * obj.input("a"); // return []. There are no sentences that have prefix "i a".
     * obj.input("#"); // return []. The user finished the input, the sentence "i a" should be saved as a historical sentence in system. And the following input will be counted as a new search.
     */

    public AutocompleteSystem(String[] sentences, int[] times) {
    }

    public List<String> input(char c) {
        return null;
    }

}
