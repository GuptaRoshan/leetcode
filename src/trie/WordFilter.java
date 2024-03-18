package trie;


class WordFilter {
    class TrieNode {
        TrieNode[] children;
        int weight;
        public TrieNode() {
            weight = 0;
            children = new TrieNode[27];
        }
    }
    TrieNode root;
    public WordFilter(String[] words) {
        root = new TrieNode();
        for (int weight = 0; weight < words.length; weight++) {
            String word = '{' + words[weight];
            insert(root, word, weight);
            for (int i = 0; i < word.length(); i++) {
                //skip first '{' in word
                insert(root, word.substring(i+1) + word, weight);
            }
        }
    }

    // add "apple{apple", "pple{apple", "ple{apple", "le{apple", "e{apple", "{apple" into the Trie Tree
    // String the suffix of with {
    private void insert(TrieNode root, String word, int weight) {
        TrieNode cur = root;
        for(char c : word.toCharArray()) {
            int k = c - 'a';
            if(cur.children[k] == null) {
                cur.children[k] = new TrieNode();
            }
            cur = cur.children[k];
            cur.weight = weight;
        }
    }

    public int f(String prefix, String suffix) {
        TrieNode cur = root;
        System.out.println(suffix + '{' + prefix);
        for(char c : (suffix + '{' + prefix).toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                return -1;
            }
            cur = cur.children[c-'a'];
        }
        return cur.weight;
    }
}

class Test{
    public static void main(String[] args){
        WordFilter wordFilter = new WordFilter(new String[] {"apple", "ball"});
        System.out.println(wordFilter.f("a", "e"));

    }
}
