package leetcode;

/**
 * Created by k586j642 on 4/18/2016.
 */
public class Dungeon {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0) return 0;
        int row = dungeon.length, column = dungeon[0].length;
        int[][] minimumHP = new int[row][column];
        for (int j = column - 1; j > -1; j--) {
            for (int i = row - 1; i > -1; i--) {
                int x = Integer.MAX_VALUE;
                if (j + 1 < column) {
                    x = Math.min(x, minimumHP[i][j + 1] - dungeon[i][j]);
                }
                if (i + 1 < row) {
                    x = Math.min(x, minimumHP[i + 1][j] - dungeon[i][j]);
                }
                if (x == Integer.MAX_VALUE) {
                    x = 1 - dungeon[i][j];
                }
                if (x < 1) {
                    x = 1;
                }
                minimumHP[i][j] = x;
            }
        }
        return minimumHP[0][0];
    }

}
