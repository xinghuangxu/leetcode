package helper;

/**
 * Created by xinghuangxu on 8/19/15.
 */
public class WordDictionary {

    Trie root = new Trie();

    class Trie {

        boolean isWord = false;
        Trie[] tries = new Trie[27];

        void addWord(int location, String word) {
            if (location == word.length()) {
                isWord = true;
            } else {
                int index = getIndex(location, word);
                createIfAbsent(index);
                createIfAbsent(26);
                tries[26].addWord(location + 1, word);
                tries[index].addWord(location + 1, word);
            }
        }

        public boolean search(int location, String word) {
            if (location == word.length()) {
                return isWord;
            } else {
                int index = getIndex(location, word);
                if (tries[index] == null) {
                    return false;
                } else {
                    return tries[index].search(location + 1, word);
                }
            }
        }


        private void createIfAbsent(int index) {
            if (tries[index] == null) {
                tries[index] = new Trie();
            }
        }

        private int getIndex(int location, String word) {
            if (word.charAt(location) == '.') {
                return 26;
            }
            return word.charAt(location) - 'a';
        }

    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        root.addWord(0, word);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return root.search(0, word);
    }
}