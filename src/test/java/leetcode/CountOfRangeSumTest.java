package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by xinghuangxu on 3/9/16.
 */
public class CountOfRangeSumTest extends TestCase {
    @Test
    public void test1() {
        CountOfRangeSum countOfRangeSum = new CountOfRangeSum();
        int[] nums = {-2, 5, -1};
        int lower = -2;
        int upper = 2;
        assertEquals(3,countOfRangeSum.countRangeSum(nums,lower,upper));
    }
}