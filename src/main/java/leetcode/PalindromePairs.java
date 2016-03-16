package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by k586j642 on 3/16/2016.
 */
public class PalindromePairs {

    List<List<Integer>> result;

    class Trie {
        boolean isWord = false;
        int index;
        List<Integer> suffixPalindromeWordIndexes = new ArrayList<Integer>();
        Trie[] children = new Trie[26];

        void add(String word, int i, int wordIndex) {
            if (word.length() > i) {
                int nIndex = word.charAt(i) - 'a';
                if (children[nIndex] == null) {
                    children[nIndex] = new Trie();
                }
                children[nIndex].add(word, i + 1, wordIndex);
                if (isSuffixPalindrome(word, i)) {
                    this.suffixPalindromeWordIndexes.add(wordIndex);
                }
            } else if (word.length() == i) {
                isWord = true;
                index = wordIndex;
            }
        }

        public Trie reverseFind(String word, int i, List<Integer> palindromePrefixCandidates) {
            if (i == -1) {
                return this;
            } else {
                if (isWord && isPrefixPalindrome(word, i)) {
                    palindromePrefixCandidates.add(index);
                }
                int nIndex = word.charAt(i) - 'a';
                if (children[nIndex] != null) {
                    return children[nIndex].reverseFind(word, i - 1, palindromePrefixCandidates);
                }
                return null;
            }
        }
    }

    private boolean isPrefixPalindrome(String word, int end) {
        int i = 0, j = end;
        while (i <= j) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isSuffixPalindrome(String word, int start) {
        int i = start, j = word.length() - 1;
        while (i <= j) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        result = new ArrayList();
        Trie root = new Trie();
        for (int i = 0; i < words.length; i++) {
            root.add(words[i], 0, i);
        }
        findPalindromePairs(words, root);
        return result;
    }

    private void findPalindromePairs(String[] words, Trie root) {
        for (int i = 0; i < words.length; i++) {
            List<Integer> palindromePrefixCandidates = new ArrayList<Integer>();
            Trie target = root.reverseFind(words[i], words[i].length() - 1, palindromePrefixCandidates);
            if (target != null) {
                if (target.isWord && target.index != i) { //word[target.index].length == words[i].length
                    List<Integer> pair = new ArrayList(2);
                    pair.add(i);
                    pair.add(target.index);
                    result.add(pair);
                }
                List<Integer> palindromeWords = target.suffixPalindromeWordIndexes;
                for (int j = 0; j < palindromeWords.size(); j++) { //word[palindromeWords.get(j)].length > words[i].length
                    if (i != palindromeWords.get(j)) {
                        List<Integer> pair = new ArrayList(2);
                        pair.add(palindromeWords.get(j));
                        pair.add(i);
                        result.add(pair);
                    }
                }
            }
            for (int j = 0; j < palindromePrefixCandidates.size(); j++) { //word[palindromeWords.get(j)].length < words[i].length
                 if (i != palindromePrefixCandidates.get(j)) {
                    List<Integer> pair = new ArrayList(2);
                    pair.add(palindromePrefixCandidates.get(j));
                    pair.add(i);
                    result.add(pair);
                }
            }
        }
    }

}
