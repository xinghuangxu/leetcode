package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

/**
 * Created by xinghuangxu on 4/10/16.
 */
public class CombinationSum3Test extends TestCase {
    @Test
    public void test1() {

        CombinationSum3 combinationSum3 = new CombinationSum3();
        int k = 3;
        int n = 7;
        List<List<Integer>> result = combinationSum3.combinationSum3(k,n);
        assertEquals(1, result.size());
    }
}