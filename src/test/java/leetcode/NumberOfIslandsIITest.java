package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by k586j642 on 4/14/2016.
 */
public class NumberOfIslandsIITest extends TestCase {
    @Test
    public void test1() {
        NumberOfIslandsII numberOfIslandsII = new NumberOfIslandsII();
        int m = 3, n = 3;
        int[][] positions = new int[][]{
                {0, 0},
                {0, 1},
                {1, 2},
                {2, 1}
        };
        List<Integer> actual = numberOfIslandsII.numIslands2(m, n, positions);
        int[] expected = new int[]{1, 1, 2, 3};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], (int) actual.get(i));
        }
    }

    @Test
    public void test2() {
        NumberOfIslandsII numberOfIslandsII = new NumberOfIslandsII();
        int m = 2, n = 2;
        int[][] positions = new int[][]{
                {0, 0},
                {1, 1},
                {0, 1}
        };
        List<Integer> actual = numberOfIslandsII.numIslands2(m, n, positions);
        int[] expected = new int[]{1, 2, 1};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], (int) actual.get(i));
        }
    }

    @Test
    public void test3() {
        NumberOfIslandsII numberOfIslandsII = new NumberOfIslandsII();
        int m = 3, n = 3;
        int[][] positions = new int[][]{
                {0, 1},
                {1, 2},
                {2, 1},
                {1, 0},
                {0, 2},
                {0, 0},
                {1, 1}
        };
        List<Integer> actual = numberOfIslandsII.numIslands2(m, n, positions);
        int[] expected = new int[]{1, 2, 3, 4, 3, 2, 1};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], (int) actual.get(i));
        }
    }
}