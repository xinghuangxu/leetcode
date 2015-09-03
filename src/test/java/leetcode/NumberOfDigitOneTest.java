package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Xinghuang Leon Xu on 9/2/2015.
 */
public class NumberOfDigitOneTest extends TestCase {
    @Test
    public void test1() {
        int n = 13;
        NumberOfDigitOne numberOfDigitOne = new NumberOfDigitOne();
        assertEquals(6, numberOfDigitOne.countDigitOne(n));
    }

    @Test
    public void test2() {
        int n = 3184191;
        NumberOfDigitOne numberOfDigitOne = new NumberOfDigitOne();
        assertEquals(2978524, numberOfDigitOne.countDigitOne(n));
    }

    @Test
    public void test21() {
        int n = 999999;
        NumberOfDigitOne numberOfDigitOne = new NumberOfDigitOne();
        assertEquals(600000, numberOfDigitOne.countDigitOne(n));
    }

    @Test
    public void test22() {
        int n = 999;
        NumberOfDigitOne numberOfDigitOne = new NumberOfDigitOne();
        assertEquals(300, numberOfDigitOne.countDigitOne(n));
    }

    @Test
    public void test24() {
        int n = 9999;
        NumberOfDigitOne numberOfDigitOne = new NumberOfDigitOne();
        assertEquals(4000, numberOfDigitOne.countDigitOne(n));
    }

    @Test
    public void test23() {
        int n = 184191;
        NumberOfDigitOne numberOfDigitOne = new NumberOfDigitOne();
        assertEquals(178524, numberOfDigitOne.countDigitOne(n));
    }

    @Test
    public void test3() {
        int n = 113;
        NumberOfDigitOne numberOfDigitOne = new NumberOfDigitOne();
        assertEquals(40, numberOfDigitOne.countDigitOne(n));
    }

    @Test
    public void test4() {
        int n = 99;
        NumberOfDigitOne numberOfDigitOne = new NumberOfDigitOne();
        assertEquals(20, numberOfDigitOne.countDigitOne(n));
    }

    @Test
    public void test5() {
        int n = 400;
        NumberOfDigitOne numberOfDigitOne = new NumberOfDigitOne();
        assertEquals(180, numberOfDigitOne.countDigitOne(n));
    }

    @Test
    public void test6() {
        int n = 413;
        NumberOfDigitOne numberOfDigitOne = new NumberOfDigitOne();
        assertEquals(186, numberOfDigitOne.countDigitOne(n));
    }

}