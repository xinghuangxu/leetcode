package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by k586j642 on 3/29/2016.
 */
public class SuperUglyNumberTest extends TestCase {
    @Test
    public void test1() {
        SuperUglyNumber superUglyNumber = new SuperUglyNumber();
        int actual = superUglyNumber.nthSuperUglyNumber(12, new int[]{2, 7, 13, 19});
        assertEquals(32, actual);
    }
}