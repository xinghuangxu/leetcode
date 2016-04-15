package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by k586j642 on 4/15/2016.
 */
public class ShortestDistanceFromAllBuildings {

    class Search {
        Stack<int[]> front = new Stack();
        int distance = 0;
        boolean[][] visited;

        Search(int x, int y, int rowCount, int colCount) {
            front.add(new int[]{x, y});
            visited = new boolean[rowCount][colCount];
            visited[x][y] = true;
        }

        public void expand(int[][] sum, int[][] meetupCount, int[][] grid) {
            Stack<int[]> nFront = new Stack();
            while (!front.isEmpty()) {
                int[] cur = front.pop();
                int x = cur[0], y = cur[1];
                sum[x][y] += distance;
                meetupCount[x][y]++;
                if (x - 1 > -1 && !visited[x - 1][y] && grid[x - 1][y] == 0) {
                    visited[x - 1][y] = true;
                    nFront.add(new int[]{x - 1, y});
                }
                if (x + 1 < visited.length && !visited[x + 1][y] && grid[x + 1][y] == 0) {
                    visited[x + 1][y] = true;
                    nFront.add(new int[]{x + 1, y});
                }
                if (y + 1 < visited[0].length && !visited[x][y + 1] && grid[x][y + 1] == 0) {
                    visited[x][y + 1] = true;
                    nFront.add(new int[]{x, y + 1});
                }
                if (y - 1 > -1 && !visited[x][y - 1] && grid[x][y - 1] == 0) {
                    visited[x][y - 1] = true;
                    nFront.add(new int[]{x, y - 1});
                }
            }
            front = nFront;
            distance++;
        }
    }

    public int shortestDistance(int[][] grid) {
        int rowCount = grid.length;
        if (rowCount < 1) return 0;
        int colCount = grid[0].length;
        Queue<Search> searchQueue = new ArrayDeque();
        int personCount = 0;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (grid[i][j] == 1) {
                    searchQueue.add(new Search(i, j, rowCount, colCount));
                    personCount++;
                }
            }
        }
        int[][] sum = new int[rowCount][colCount];
        int[][] meetupCount = new int[rowCount][colCount];
        while (!searchQueue.isEmpty()) {
            Search tmp = searchQueue.poll();
            tmp.expand(sum, meetupCount, grid);
            if (tmp.front.size() > 0) {
                searchQueue.add(tmp);
            }
        }
        int shortestDistance = Integer.MAX_VALUE;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (grid[i][j] == 0 && meetupCount[i][j] == personCount && sum[i][j] < shortestDistance) {
                    shortestDistance = sum[i][j];
                }
            }
        }
        if (shortestDistance == Integer.MAX_VALUE) return -1;
        return shortestDistance;
    }

    /*
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rowCount = grid.length, colCount = grid[0].length;
        int[] rowSum = new int[rowCount], colSum = new int[colCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (grid[i][j] == 1) {
                    rowSum[i]++;
                    colSum[j]++;
                }
            }
        }
        int minDistance = Integer.MAX_VALUE;
        rowSum = findMedianDistanceSum(rowSum);
        colSum = findMedianDistanceSum(colSum);
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (grid[i][j] == 0 && rowSum[i] + colSum[j] < minDistance) {
                    minDistance = rowSum[i] + colSum[j];
                }
            }
        }
        if (minDistance == Integer.MAX_VALUE) return -1;
        return minDistance;
    }

    private int[] findMedianDistanceSum(int[] rowSum) {
        int leftSum = 0, rightSum = 0;
        int leftToRightSum[] = new int[rowSum.length];
        for (int i = 1; i < rowSum.length; i++) {
            leftSum += rowSum[i - 1];
            leftToRightSum[i] += leftToRightSum[i - 1] + leftSum;

        }
        int rightToLeftSum[] = new int[rowSum.length];
        for (int i = rowSum.length - 2; i > -1; i--) {
            rightSum += rowSum[i + 1];
            rightToLeftSum[i] += rightToLeftSum[i + 1] + rightSum;

        }
        int[] sum = new int[rowSum.length];
        for (int i = 0; i < rowSum.length; i++) {
            sum[i] = leftToRightSum[i] + rightToLeftSum[i];
        }
        return sum;
    }
    */
}
