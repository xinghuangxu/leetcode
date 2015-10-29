package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xinghuangxu on 9/19/15.
 */
public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        // use two LinkedList to store the original word list and the result word list
        List<String> originalList = new LinkedList<String>();
        List<String> resultList = new LinkedList<String>();
        for (String s: words) {
            originalList.add(s);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                for (int k = 0; k < originalList.size(); k++) {
                    if (originalList.get(k).charAt(0) == board[i][j]) {
                        boolean[][] visited = new boolean[board.length][board[0].length];
                        for (boolean[] arr: visited) {
                            Arrays.fill(arr, false);
                        }
                        if (findWordsHelper(board, visited, i, j, originalList.get(k), 0)) {
                            resultList.add(originalList.get(k));
                            originalList.remove(k);
                        }
                    }
                }
                if (0 == originalList.size()) break;
            }
            if (0 == originalList.size()) break;
        }
        return resultList;
    }

    public boolean findWordsHelper(char[][]board, boolean[][] visited, int i, int j, String word, int index) {
        // check index out of bound
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        // check visited and character match
        if (visited[i][j] || board[i][j] != word.charAt(index)) return false;

        visited[i][j] = true;
        if (index == word.length() - 1) {
            return true;
        } else {
            boolean hasNext = findWordsHelper(board, visited, i + 1, j, word, index + 1) ||
                    findWordsHelper(board, visited, i - 1, j, word, index + 1) ||
                    findWordsHelper(board, visited, i, j + 1, word, index + 1) ||
                    findWordsHelper(board, visited, i, j - 1, word, index + 1);
            if (hasNext) {
                return true;
            } else {
                visited[i][j] = false;
                return false;
            }
        }
    }
}