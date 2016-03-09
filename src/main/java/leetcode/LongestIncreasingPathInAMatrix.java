package leetcode;

/**
 * Created by k586j642 on 3/4/2016.
 */
public class LongestIncreasingPathInAMatrix {

    int[] xdirection = {1, 0, -1, 0};
    int[] ydirection = {0, 1, 0, -1};
    int rowSize;
    int columnSize;
    int[][] longestPathMatrix;
    int[][] valueMatrix;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        rowSize = matrix.length;
        columnSize = matrix[0].length;
        longestPathMatrix = new int[rowSize][columnSize];
        valueMatrix = matrix;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                int tmp = getLongestPathValue(i, j);
                if (tmp > max) {
                    max = tmp;
                }
            }
        }
        return max;
    }

    private boolean isValid(int x, int y) {
        if (x < 0 || x >= rowSize) return false;
        if (y < 0 || y >= columnSize) return false;
        return true;
    }


    private int getLongestPathValue(int x, int y) {
        int longestPath = longestPathMatrix[x][y];
        if (longestPath != 0) return longestPath;
        //find the longest path
        longestPath = 0;
        int current = valueMatrix[x][y];
        for (int i = 0; i < xdirection.length; i++) {
            if (isValid(x + xdirection[i], y + ydirection[i])) {
                int value = valueMatrix[x + xdirection[i]][y + ydirection[i]];
                if (value > current) {
                    int tmp = getLongestPathValue(x + xdirection[i], y + ydirection[i]);
                    if (tmp > longestPath) longestPath = tmp;
                }
            }

        }
        longestPathMatrix[x][y] = longestPath + 1;
        return longestPath + 1;
    }

}
