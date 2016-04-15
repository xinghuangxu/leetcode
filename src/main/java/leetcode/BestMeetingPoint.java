package leetcode;

/**
 * Created by k586j642 on 4/15/2016.
 */
public class BestMeetingPoint {

    public int minTotalDistance(int[][] grid) {
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
        int minDistance = 0;
        minDistance += findMedianDistanceSum(rowSum);
        minDistance += findMedianDistanceSum(colSum);
        return minDistance;
    }

    private int findMedianDistanceSum(int[] rowSum) {
        int left = 0, right = rowSum.length - 1;
        int leftSum = rowSum[left], rightSum = rowSum[right], sum = 0;
        while (left < right) {
            if (leftSum < rightSum) {
                left += 1;
                sum += leftSum;
                leftSum += rowSum[left];
            } else {
                right -= 1;
                sum += rightSum;
                rightSum += rowSum[right];
            }
        }
        return sum;
    }
    /*
    class Search {
        Stack<int[]> front = new Stack();
        int distance = 0;
        boolean[][] visited;

        Search(int x, int y, int rowCount, int colCount) {
            front.add(new int[]{x, y});
            visited = new boolean[rowCount][colCount];
        }

        public int expand(int[][] sum, int[][] meetupCount, int personCount) {
            Stack<int[]> nFront = new Stack();
            while (!front.isEmpty()) {
                int[] cur = front.pop();
                int x = cur[0], y = cur[1];
                visited[x][y] = true;
                sum[x][y] += distance;
                meetupCount[x][y]++;
                if (meetupCount[x][y] == personCount) {
                    return sum[x][y];
                }
                if (x - 1 > -1 && !visited[x - 1][y]) {
                    nFront.add(new int[]{x - 1, y});
                }
                if (x + 1 < visited.length && !visited[x + 1][y]) {
                    nFront.add(new int[]{x + 1, y});
                }
                if (y + 1 < visited[0].length && !visited[x][y + 1]) {
                    nFront.add(new int[]{x, y + 1});
                }
                if (y - 1 > -1 && !visited[x][y - 1]) {
                    nFront.add(new int[]{x, y - 1});
                }
            }
            front = nFront;
            distance++;
            return -1;
        }
    }

    public int minTotalDistance(int[][] grid) {
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
            int result = tmp.expand(sum, meetupCount, personCount);
            if (result != -1) {
                return result;
            }
            searchQueue.add(tmp);
        }
        return 0;
    }
    */
}
