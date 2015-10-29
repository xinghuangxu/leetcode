package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Xinghuang Leon Xu on 9/3/2015.
 */
public class SearchA2DMatrixIITest extends TestCase {
    @Test
    public void test1() {
        int[][] matrix = getDefaultMatrix();
        SearchA2DMatrixII searchA2DMatrixII = new SearchA2DMatrixII();
        assertEquals(true, searchA2DMatrixII.searchMatrix(matrix, 5));
        assertEquals(false, searchA2DMatrixII.searchMatrix(matrix, 20));
    }

    public int[][] getDefaultMatrix() {
        return new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
    }
}