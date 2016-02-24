package leetcode;

/**
 * Created by xinghuangxu on 10/29/15.
 */
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int m = board.length + 2, n = board[0].length + 2;
        int[][] nboard = new int[m][n];
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                nboard[i][j] = board[i - 1][j - 1];
            }
        }
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                int liveCount = getLiveCount(i, j, nboard);
                if (board[i - 1][j - 1] == 1) {
                    if (liveCount < 2) {
                        board[i - 1][j - 1] = 0;
                    } else if (liveCount > 3) {
                        board[i - 1][j - 1] = 0;
                    }
                } else {
                    if (liveCount == 3) {
                        board[i - 1][j - 1] = 1;
                    }
                }

            }
        }

    }

    private int getLiveCount(int i, int j, int[][] nboard) {
        int liveCount = 0;
        if (nboard[i + 1][j] == 1) {
            liveCount++;
        }
        if (nboard[i - 1][j] == 1) {
            liveCount++;
        }
        if (nboard[i][j + 1] == 1) {
            liveCount++;
        }
        if (nboard[i][j - 1] == 1) {
            liveCount++;
        }
        if (nboard[i - 1][j + 1] == 1) {
            liveCount++;
        }
        if (nboard[i - 1][j - 1] == 1) {
            liveCount++;
        }
        if (nboard[i + 1][j - 1] == 1) {
            liveCount++;
        }
        if (nboard[i + 1][j + 1] == 1) {
            liveCount++;
        }
        return liveCount;
    }
}
