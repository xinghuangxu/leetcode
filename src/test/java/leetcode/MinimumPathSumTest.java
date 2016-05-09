package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by k586j642 on 4/18/2016.
 */
public class MinimumPathSumTest extends TestCase {
    @Test
    public void test1() {
        MinimumPathSum minimumPathSum = new MinimumPathSum();
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        assertEquals(7,minimumPathSum.minPathSum(grid));
    }
}