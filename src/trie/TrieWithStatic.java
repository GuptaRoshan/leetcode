package trie;

import java.util.Arrays;

public class TrieWithStatic {
    static final int SIZE = 26;
    static TrieNode root;


    static class TrieNode {
        TrieNode[] children = new TrieNode[SIZE];
        Boolean isEndOfWord;

        public TrieNode() {
            Arrays.fill(children, null);
            isEndOfWord = false;
        }
    }

    static void insert(String key) {
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

    static boolean search(String key) {
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

    public static void main(String[] args) {
        root = new TrieNode();
        insert("apple");
        insert("ball");
        insert("app");
        insert("cat");
        System.out.println(search("cat"));
    }

}
