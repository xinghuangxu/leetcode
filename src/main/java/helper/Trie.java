package helper;

/**
 * Created by xinghuangxu on 8/18/15.
 */
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        root.add(0, word);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        return root.search(0, word);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return root.startsWith(0, prefix);
    }
}