package systemDesign;

import java.util.Arrays;

public class Trie {
    static final int SIZE = 26;
    static TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String key) {
        TrieNode temp = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (temp.children[index] == null) {
                temp.children[index] = new TrieNode();
            }
            temp = temp.children[index];
        }
        temp.isEndOfWord = true;
    }

    public boolean search(String key) {
        TrieNode temp = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (temp.children[index] == null) {
                return false;
            }
            temp = temp.children[index];
        }
        return temp.isEndOfWord;
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[SIZE];
        Boolean isEndOfWord;

        public TrieNode() {
            Arrays.fill(children, null);
            isEndOfWord = false;
        }
    }
}

class TrieTest {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("ball");
        trie.insert("app");
        trie.insert("cat");
        trie.search("balls");
    }
}