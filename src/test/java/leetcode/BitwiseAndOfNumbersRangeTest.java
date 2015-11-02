package leetcode;

import org.junit.Test;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by xinghuangxu on 8/2/15.
 */
public class BitwiseAndOfNumbersRangeTest {


    @Test
    public void test1() {
        int m = 5;
        int n = 7;
        BitwiseAndOfNumbersRange bitwiseAndOfNumbersRange = new BitwiseAndOfNumbersRange();
        int actual=bitwiseAndOfNumbersRange.rangeBitwiseAnd(m, n);
        assertEquals(4,actual);
    }

    //0, 2147483647
    @Test
    public void test2() {
        int m = 0;
        int n = 2147483647;
        BitwiseAndOfNumbersRange bitwiseAndOfNumbersRange = new BitwiseAndOfNumbersRange();
        int actual=bitwiseAndOfNumbersRange.rangeBitwiseAnd(m, n);
        assertEquals(0,actual);
    }

    //2147483647, 2147483647
    @Test
    public void test3() {
        int m = 2147483647;
        int n = 2147483647;
        BitwiseAndOfNumbersRange bitwiseAndOfNumbersRange = new BitwiseAndOfNumbersRange();
        int actual=bitwiseAndOfNumbersRange.rangeBitwiseAnd(m, n);
        assertEquals(2147483647,actual);
    }

    @Test
    public void test4() {
        int m = 1;
        int n = 2;
        BitwiseAndOfNumbersRange bitwiseAndOfNumbersRange = new BitwiseAndOfNumbersRange();
        int actual=bitwiseAndOfNumbersRange.rangeBitwiseAnd(m, n);
        assertEquals(0,actual);
    }

    //700000000, 2147483641
    @Test
    public void test5() {
        int m = 700000000;
        int n = 2147483641;
        BitwiseAndOfNumbersRange bitwiseAndOfNumbersRange = new BitwiseAndOfNumbersRange();
        int actual=bitwiseAndOfNumbersRange.rangeBitwiseAnd(m, n);
        assertEquals(0,actual);
    }

    @Test
    public void test6() {
        int m = 2;
        int n = 2;
        BitwiseAndOfNumbersRange bitwiseAndOfNumbersRange = new BitwiseAndOfNumbersRange();
        int actual=bitwiseAndOfNumbersRange.rangeBitwiseAnd(m, n);
        assertEquals(2,actual);
    }

    @Test
    public void test7() {
        int m = 2147483647;
        int n = 2147483647;
        BitwiseAndOfNumbersRange bitwiseAndOfNumbersRange = new BitwiseAndOfNumbersRange();
        int actual=bitwiseAndOfNumbersRange.rangeBitwiseAnd(m, n);
        assertEquals(2147483647,actual);
    }
}