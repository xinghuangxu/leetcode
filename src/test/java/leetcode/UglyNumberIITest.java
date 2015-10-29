package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by Xinghuang Leon Xu on 10/26/2015.
 */
public class UglyNumberIITest extends TestCase {

    @Test
    public void test1() {
        UglyNumberII uglyNumberII = new UglyNumberII();
        assertEquals(12,uglyNumberII.nthUglyNumber(10));
    }

}