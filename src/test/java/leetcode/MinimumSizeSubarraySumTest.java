package leetcode;


import helper.Trie;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by xinghuangxu on 8/18/15.
 */
public class MinimumSizeSubarraySumTest {
    @Test
    public void test1() {
        MinimumSizeSubarraySum minimumSizeSubarraySum = new MinimumSizeSubarraySum();
        int[] nums = {2,3,1,2,4,3};
        int minLength = minimumSizeSubarraySum.minSubArrayLen(7,nums);
        assertEquals(2,minLength);
    }

    @Test
    public void test2() {
        MinimumSizeSubarraySum minimumSizeSubarraySum = new MinimumSizeSubarraySum();
        int[] nums = {};
        int minLength = minimumSizeSubarraySum.minSubArrayLen(100,nums);
        assertEquals(0,minLength);
    }

    @Test
    public void test3() {
        MinimumSizeSubarraySum minimumSizeSubarraySum = new MinimumSizeSubarraySum();
        int[] nums = {10,5,13,4,8,4,5,11,14,9,16,10,20,8};
        //80, [10,5,13,4,8,4,5,11,14,9,16,10,20,8]
        int minLength = minimumSizeSubarraySum.minSubArrayLen(80,nums);
        assertEquals(6,minLength);
    }
}