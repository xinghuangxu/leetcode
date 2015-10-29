package clrs;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Xinghuang Leon Xu on 9/29/2015.
 */
public class MatrixChainMultiplicationTest extends TestCase {

    @Test
    public void test1() {
        int[] sol = new int[]{20, 40, 50, 10, 5, 100, 2000, 20};
        Arrays.sort(sol);
        MatrixChainMultiplication multiplication = new MatrixChainMultiplication();
        int[][] actual = multiplication.matrixChainMultiplication(new int[][]{
                {30, 35},
                {35, 15},
                {15, 5},
                {5, 10},
                {10, 20},
                {20, 25}
        });
        assertEquals(7, actual);
    }

    @Test
    public void test3() {
        MatrixChainMultiplication multiplication = new MatrixChainMultiplication();
        int actual = multiplication.matrixChainMultiplicationGreedy(new int[][]{
                {3, 2},
                {2, 3},
                {3, 4}
        });
        assertEquals(7, actual);
    }

    @Test
    public void test4() {
        MatrixChainMultiplication multiplication = new MatrixChainMultiplication();
        int actual = multiplication.matrixChainMultiplicationGreedy(new int[][]{
                {30, 35},
                {35, 15},
                {15, 5},
                {5, 10},
                {10, 20},
                {20, 25}
        });
        assertEquals(7, actual);
    }

    @Test
    public void test5() {
        MatrixChainMultiplication multiplication = new MatrixChainMultiplication();
        int actual = multiplication.matrixChainMultiplicationGreedy(new int[][]{
                {10, 5},
                {5, 10},
                {10, 20},
                {20, 5},
                {5, 100},
                {100, 2}
        });
        assertEquals(7, actual);
    }

    @Test
    public void test2() {
        MatrixChainMultiplication multiplication = new MatrixChainMultiplication();
        int[][] actual = multiplication.matrixChainMultiplication(new int[][]{
                {10, 5},
                {5, 10},
                {10, 20},
                {20, 5},
                {5, 100},
                {100, 2}
        });
        assertEquals(7, actual);
    }

}