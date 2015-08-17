package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xinghuangxu on 8/2/15.
 */
public class NumberOfIslands1Test {
    @Test
    public void test1() {
        /*
        11000
        11000
        00100
        00011
         */
        char[][] grid = {
                { '1', '1','0','0','0' },
                { '1', '1','0','0','0' },
                { '0', '0','1','0','0' },
                { '0', '0','0','1','1' }
        };
        NumberOfIslands1 numberOfIslands = new NumberOfIslands1();
        int actual = numberOfIslands.numIslands(grid);
        assertEquals(3, actual);
    }

    @Test
    public void test2() {
        /*
        11000
        11000
        00100
        00011
         */
        char[][] grid = {
                { '1' }
        };
        NumberOfIslands1 numberOfIslands = new NumberOfIslands1();
        int actual = numberOfIslands.numIslands(grid);
        assertEquals(1, actual);
    }
}