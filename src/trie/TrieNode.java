package trie;

public class TrieNode {
    public boolean isWord;
    TrieNode[] children = new TrieNode[26];
    public TrieNode() {
    }
}
