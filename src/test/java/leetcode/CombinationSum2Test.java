package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

/**
 * Created by xinghuangxu on 4/10/16.
 */
public class CombinationSum2Test extends TestCase {
    @Test
    public void test1() {

        CombinationSum2 combinationSum2 = new CombinationSum2();
        int[] candidates ={1};
        int target = 2;
        List<List<Integer>> result = combinationSum2.combinationSum2(candidates,target);
        assertEquals(0, result.size());
    }

    @Test
    public void test2() {

        CombinationSum2 combinationSum2 = new CombinationSum2();
        int[] candidates ={1,1};
        int target = 1;
        List<List<Integer>> result = combinationSum2.combinationSum2(candidates, target);
        assertEquals(1, result.size());
    }

    @Test
    public void test3() {

        CombinationSum2 combinationSum2 = new CombinationSum2();
        int[] candidates ={1,1};
        int target = 2;
        List<List<Integer>> result = combinationSum2.combinationSum2(candidates, target);
        assertEquals(1, result.size());
    }

}