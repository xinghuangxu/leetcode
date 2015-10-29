package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Xinghuang Leon Xu on 9/4/2015.
 */
public class HIndexTest extends TestCase {
    @Test
    public void test1() {
        HIndex hIndex = new HIndex();
        assertEquals(3, hIndex.hIndex(new int[]{3, 0, 6, 1, 5}));
    }
}