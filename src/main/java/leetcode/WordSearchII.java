package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xinghuangxu on 9/19/15.
 */
public class WordSearchII {

    class TrieNode {

        TrieNode(int value) {
            this.value = value - 'a';
        }

        int value;

        List<TrieNode>[] trieNodes = new List[26];

        void addChild(TrieNode trieNode) {
            if (trieNode != null) {
                if (trieNodes[trieNode.value] == null) {
                    trieNodes[trieNode.value] = new ArrayList<TrieNode>();
                }
                trieNodes[trieNode.value].add(trieNode);
            }
        }

        public boolean find(String word, int index) {
            if (index == word.length()) {
                return true;
            }
            List<TrieNode> list = trieNodes[word.charAt(index) - 'a'];
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).find(word, index + 1)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    TrieNode[][] trieBoard;
    int rowSize;
    int columnSize;

    public List<String> findWords(char[][] board, String[] words) {
        //Initialize
        rowSize = board.length;
        columnSize = board[0].length;
        trieBoard = new TrieNode[rowSize][columnSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                trieBoard[i][j] = new TrieNode(board[i][j]);
            }
        }

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                trieBoard[i][j].addChild(getBoardValue(i - 1, j));
                trieBoard[i][j].addChild(getBoardValue(i + 1, j));
                trieBoard[i][j].addChild(getBoardValue(i, j - 1));
                trieBoard[i][j].addChild(getBoardValue(i, j + 1));
            }
        }

        TrieNode root = new TrieNode(-1);
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                root.addChild(trieBoard[i][j]);
            }
        }

        List<String> result = new ArrayList<String>();
        for (int i = 0; i < words.length; i++) {
            if (root.find(words[i], 0)) {
                result.add(words[i]);
            }
        }
        return result;
    }

    private TrieNode getBoardValue(int i, int j) {
        if (i > -1 && i < rowSize && j > -1 && j < columnSize) {
            return trieBoard[i][j];
        }
        return null;
    }
}
