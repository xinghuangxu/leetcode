package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by k586j642 on 8/21/2015.
 */
public class MaximalSquareTest extends TestCase {
    @Test
    public void test1() {
        MaximalSquare maximalSquare = new MaximalSquare();
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'},
        };
        int k = maximalSquare.maximalSquare(matrix);
        assertEquals(4, k);
    }

    @Test
    public void test2() {
        MaximalSquare maximalSquare = new MaximalSquare();
        char[][] matrix = {
                {'1', '1'},
                {'1', '1'}
        };
        int k = maximalSquare.maximalSquare(matrix);
        assertEquals(4, k);
    }

    @Test
    public void test3() {
        MaximalSquare maximalSquare = new MaximalSquare();
        char[][] matrix = {
                {'0', '0', '0', '1'},
                {'1', '1', '0', '1'},
                {'1', '1', '1', '1'},
                {'0', '1', '1', '1'},
                {'0', '1', '1', '1'}
        };
        int k = maximalSquare.maximalSquare(matrix);
        assertEquals(9, k);
    }
}