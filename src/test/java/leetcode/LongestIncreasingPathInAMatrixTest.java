package leetcode;

import junit.framework.TestCase;
import org.testng.annotations.Test;

/**
 * Created by k586j642 on 3/4/2016.
 */
public class LongestIncreasingPathInAMatrixTest extends TestCase {
    @Test
    public void test1() {
        LongestIncreasingPathInAMatrix longestIncreasingPathInAMatrix = new LongestIncreasingPathInAMatrix();
        int[][] nums = {
                {9,9,4},
                {6,6,8},
                {2,1,1}
        };
        int expected = 4;
        int actual = longestIncreasingPathInAMatrix.longestIncreasingPath(nums);
        assertEquals(expected,actual);
    }

    @Test
    public void test2() {
        LongestIncreasingPathInAMatrix longestIncreasingPathInAMatrix = new LongestIncreasingPathInAMatrix();
        int[][] nums = {
                {3,4,5},
                {3,2,6},
                {2,2,1}
        };
        int expected = 4;
        int actual = longestIncreasingPathInAMatrix.longestIncreasingPath(nums);
        assertEquals(actual,expected);
    }
}