package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

/**
 * Created by k586j642 on 4/6/2016.
 */
public class FourSumTest extends TestCase {
    @Test
    public void test1() {
        FourSum fourSum = new FourSum();
        int[] nums = {1, 0, -1, 0, -2 ,2 };
        List<List<Integer>> result = fourSum.fourSum(nums,0);

    }
}