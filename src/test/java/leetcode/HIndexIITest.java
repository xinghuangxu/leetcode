package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by Xinghuang Leon Xu on 10/29/2015.
 */
public class HIndexIITest extends TestCase {
    @Test
    public void test1() {
        HIndexII hIndex = new HIndexII();
        assertEquals(3, hIndex.hIndex(new int[]{0, 1, 3, 5, 6}));
    }
}