package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by xinghuangxu on 4/6/16.
 */
public class ThreeSumSmallerTest extends TestCase {
    @Test
    public void test1() {
        ThreeSumSmaller threeSumSmaller = new ThreeSumSmaller();
        int[] nums = {-2, 0, 1, 3};
        int target = 2;
        assertEquals(2, threeSumSmaller.threeSumSmaller(nums, target));
    }

    /*
    [-4,-4,-4,3,2,-4,2,-2,-3,2,3,-3,0,-1]
-12
     */

    @Test
    public void test2() {
        ThreeSumSmaller threeSumSmaller = new ThreeSumSmaller();
        int[] nums = {-4,-4,-4,3,2,-4,2,-2,-3,2,3,-3,0,-1};
        int target = -12;
        assertEquals(2, threeSumSmaller.threeSumSmaller(nums, target));
    }

    /*
    [-1,1,-1,0]
-1
     */
    @Test
    public void test3() {
        ThreeSumSmaller threeSumSmaller = new ThreeSumSmaller();
        int[] nums = {-1,1,-1,0};
        int target = -1;
        assertEquals(1, threeSumSmaller.threeSumSmaller(nums, target));
    }
}