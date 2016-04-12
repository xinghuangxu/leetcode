package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

/**
 * Created by xinghuangxu on 4/7/16.
 */
public class CombinationSumTest extends TestCase {
    @Test
    public void test1() {

        CombinationSum combinationSum = new CombinationSum();
        int[] candidates ={2,3,6,7};
        int target = 7;
        List<List<Integer>> result = combinationSum.combinationSum(candidates,target);
        assertEquals(2, result.size());
    }


    @Test
    public void test2() {

        CombinationSum combinationSum = new CombinationSum();
        int[] candidates ={1,2};
        int target = 1;
        List<List<Integer>> result = combinationSum.combinationSum(candidates,target);
        assertEquals(1, result.size());
    }

    @Test
    public void test3() {

        CombinationSum combinationSum = new CombinationSum();
        int[] candidates ={1,2};
        int target = 2;
        List<List<Integer>> result = combinationSum.combinationSum(candidates,target);
        assertEquals(2, result.size());
    }
}