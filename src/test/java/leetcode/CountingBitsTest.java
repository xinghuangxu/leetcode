package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by xinghuangxu on 3/21/16.
 */
public class CountingBitsTest extends TestCase {
    @Test
    public void test1() {
        CountingBits countingBits = new CountingBits();
        assertArrayEquals(new int[]{0, 1, 1, 2, 1, 2}, countingBits.countBits(5));
    }

}