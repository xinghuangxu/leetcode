package helper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Xinghuang Leon Xu on 9/20/2015.
 */
public class WordDictionary2 {

    private TrieNode root;

    public WordDictionary2() {
        this.root = new TrieNode(' ');
    }

    // Adds a word into the data cture.
    public void addWord(String word) {
        TrieNode cur = this.root;
        for (int i = 0; i < word.length(); i++) {
            if (!cur.childrenMap.containsKey(word.charAt(i))) {
                cur.childrenMap.put(word.charAt(i), new TrieNode(word.charAt(i)));
            }
            cur = cur.childrenMap.get(word.charAt(i));
        }
        cur.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    // children of cur contians word.charAt(i)
    public boolean search(String word) {
        return searchHelper(this.root, word, 0);
    }

    // recursive function
    // children of cur contians word.charAt(i)
    public boolean searchHelper(TrieNode cur, String word, int i) {
        if (i == word.length()) {
            return cur.isWord;
        } else {
            if ('.' == word.charAt(i)) {
                for (char ch : cur.childrenMap.keySet()) {
                    if (searchHelper(cur.childrenMap.get(ch), word, i + 1)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (!cur.childrenMap.containsKey(word.charAt(i))) {
                    return false;
                } else {
                    return searchHelper(cur.childrenMap.get(word.charAt(i)), word, i + 1);
                }
            }
        }
    }

    public class TrieNode {
        public char val;
        public boolean isWord;
        public Map<Character, TrieNode> childrenMap;

        public TrieNode(char ch) {
            this.val = ch;
            this.isWord = false;
            this.childrenMap = new HashMap<Character, TrieNode>();
        }
    }

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
}
