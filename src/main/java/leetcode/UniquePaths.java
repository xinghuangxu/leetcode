package leetcode;

/**
 * Created by k586j642 on 4/18/2016.
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        //return countUniquePaths(1, 1, m, n);
        int[] column = new int[m];
        for (int i = 0; i < m; i++) {
            column[i] = 1;
        }
        for (int j = n - 2; j > -1; j--) {
            for (int i = m - 2; i > -1; i--) {
                column[i] = column[i] + column[i + 1];
            }
        }
        return column[0];
    }
}
