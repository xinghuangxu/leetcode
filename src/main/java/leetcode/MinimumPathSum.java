package leetcode;

/**
 * Created by k586j642 on 4/18/2016.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int row = grid.length, column = grid[0].length;
        int[] minimumPath = new int[row];
        for (int j = column - 1; j > -1; j--) {
            for (int i = row - 1; i > -1; i--) {
                int x = Integer.MAX_VALUE;
                if (j + 1 < column) {
                    x = minimumPath[i] + grid[i][j];
                }
                if (i + 1 < row) {
                    x = Math.min(minimumPath[i + 1] + grid[i][j], x);
                }
                if (x == Integer.MAX_VALUE) {
                    x = grid[i][j];
                }
                minimumPath[i] = x;
            }
        }
        return minimumPath[0];
    }
}
