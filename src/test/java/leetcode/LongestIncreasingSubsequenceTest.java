package leetcode;

import junit.framework.TestCase;
import org.testng.annotations.Test;

/**
 * Created by k586j642 on 3/25/2016.
 */
public class LongestIncreasingSubsequenceTest extends TestCase {
    @Test
    public void test1() {
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int expected = 4;
        assertEquals(expected, longestIncreasingSubsequence.lengthOfLIS(nums));
    }
}