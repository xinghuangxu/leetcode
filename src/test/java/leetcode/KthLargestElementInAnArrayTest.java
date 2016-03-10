package leetcode;

import helper.Trie;
import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by k586j642 on 8/20/2015.
 */
public class KthLargestElementInAnArrayTest extends TestCase {
    @Test
    public void test1() {
        KthLargestElementInAnArray kthLargestElementInAnArray = new KthLargestElementInAnArray();
        int[] nums = {3,2,1,5,6,4};
        int k= 2;
        assertEquals(5,kthLargestElementInAnArray.findKthLargest(nums, k));
    }

    @Test
    public void test2() {
        KthLargestElementInAnArray kthLargestElementInAnArray = new KthLargestElementInAnArray();
        int[] nums = {3,2,1,5,6,4};
        int k= 3;
        assertEquals(4, kthLargestElementInAnArray.findKthLargest(nums, k));
    }

    @Test
    public void test3() {
        KthLargestElementInAnArray kthLargestElementInAnArray = new KthLargestElementInAnArray();
        int[] nums = {3,2,1,5,6,4};
        int k= 4;
        assertEquals(3, kthLargestElementInAnArray.findKthLargest(nums, k));
    }


}