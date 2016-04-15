package leetcode;

import java.util.*;

/**
 * Created by k586j642 on 4/14/2016.
 */
public class NumberOfIslandsII {

    int numIsland;

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList(positions.length);
        int label = 1;
        int[][] grid = new int[m][n];
        numIsland = 0;
        for (int i = 0; i < positions.length; i++) {
            int[] position = positions[i];
            int x = position[0], y = position[1];
            if (grid[x][y] != 0) {//has added land on this position before
                result.add(numIsland);
            } else {
                if (isConnected(x, y, grid)) {
                    result.add(numIsland);
                } else {
                    result.add(++numIsland);
                    grid[x][y] = label++;
                }
            }
        }
        return result;
    }

    private boolean isConnected(int x, int y, int[][] grid) {
        Set<Integer> labels = new HashSet();
        if (x - 1 > -1 && grid[x - 1][y] != 0) {
            labels.add(grid[x - 1][y]);
        }
        if (y - 1 > -1 && grid[x][y - 1] != 0) {
            labels.add(grid[x][y - 1]);
        }
        if (x + 1 < grid.length && grid[x + 1][y] != 0) {
            labels.add(grid[x + 1][y]);
        }
        if (y + 1 < grid[0].length && grid[x][y + 1] != 0) {
            labels.add(grid[x][y + 1]);
        }
        if (labels.size() == 0) {
            return false;
        } else {
            for (Integer l : labels) {
                if (labels.size() == 1) {
                    grid[x][y] = l;
                    return true;
                } else {
                    grid[x][y] = -1;
                    dfs(x, y, grid, l);
                    numIsland = numIsland - labels.size() + 1;
                    return true;
                }
            }
            return true;
        }
    }

    private void dfs(int x, int y, int[][] grid, Integer label) {
        if (grid[x][y] != 0 && grid[x][y] != label) {
            grid[x][y] = label;
            if (x - 1 > -1)
                dfs(x - 1, y, grid, label);
            if (y - 1 > -1)
                dfs(x, y - 1, grid, label);
            if (x + 1 < grid.length)
                dfs(x + 1, y, grid, label);
            if (y + 1 < grid[0].length)
                dfs(x, y + 1, grid, label);
        }
    }
}
