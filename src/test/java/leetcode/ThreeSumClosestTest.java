package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

/**
 * Created by k586j642 on 4/6/2016.
 */
public class ThreeSumClosestTest extends TestCase {
    @Test
    public void test1() {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        int[] nums = {-1, 2, 1, -4};
        assertEquals(2, threeSumClosest.threeSumClosest(nums, 1));
    }

    @Test
    public void test2() {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        int[] nums = {0,0,0};
        assertEquals(0, threeSumClosest.threeSumClosest(nums, 1));
    }


    @Test
    public void test3() {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        int[] nums = {0,1,2};
        assertEquals(3, threeSumClosest.threeSumClosest(nums, 3));
    }

    @Test
    public void test4() {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        int[] nums = {1,1,1,0};
        assertEquals(3, threeSumClosest.threeSumClosest(nums, 100));
    }
}