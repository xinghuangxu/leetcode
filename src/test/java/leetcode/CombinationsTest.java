package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

/**
 * Created by xinghuangxu on 4/10/16.
 */
public class CombinationsTest extends TestCase {
    @Test
    public void test1() {

        Combinations combinations = new Combinations();
        int n = 4, k = 2;
        List<List<Integer>> result = combinations.combine(n, k);
        assertEquals(6, result.size());
    }
}