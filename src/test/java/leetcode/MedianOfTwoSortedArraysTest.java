package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by xinghuangxu on 4/19/16.
 */
public class MedianOfTwoSortedArraysTest extends TestCase {
    @Test
    public void test1() {
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        int[] nums1 = {1, 12, 15, 26, 38},
                nums2 = {2, 13, 17, 30, 45};
        assertEquals(16.0, medianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void test2() {
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        int[] nums1 = {1, 12, 15},
                nums2 = {2, 13};
        assertEquals(12.0, medianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void test3() {
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        int[] nums1 = {1},
                nums2 = {1};
        assertEquals(1, medianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2));
    }
}