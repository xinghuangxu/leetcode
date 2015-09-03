package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Xinghuang Leon Xu on 9/1/2015.
 */
public class PowerOfTwoTest {

    @Test
    public void test1() {
        int n = 2;
        PowerOfTwo powerOfTwo = new PowerOfTwo();
        assertEquals(true, powerOfTwo.isPowerOfTwo(n));
    }

    @Test
    public void test2() {
        int n = 3;
        PowerOfTwo powerOfTwo = new PowerOfTwo();
        assertEquals(false, powerOfTwo.isPowerOfTwo(n));
    }

    @Test
    public void test3() {
        int n = -2147483648;
        PowerOfTwo powerOfTwo = new PowerOfTwo();
        assertEquals(false, powerOfTwo.isPowerOfTwo(n));
    }

    @Test
    public void test4() {
        int n = 0;
        PowerOfTwo powerOfTwo = new PowerOfTwo();
        assertEquals(false, powerOfTwo.isPowerOfTwo(n));
    }
}
