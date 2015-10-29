package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by xinghuangxu on 9/10/15.
 */
public class DifferentWaysToAddParenthesesTest extends TestCase {

    @Test
    public void test() {
        DifferentWaysToAddParentheses differentWaysToAddParentheses = new DifferentWaysToAddParentheses();
        List<Integer> result = differentWaysToAddParentheses.diffWaysToCompute("2*3-4*5");
        assertArrayEquals(new Integer[]{-34, -10, -14, -10, 10}, result.toArray());
    }

    @Test
    public void test1() {
        DifferentWaysToAddParentheses differentWaysToAddParentheses = new DifferentWaysToAddParentheses();
        List<Integer> result = differentWaysToAddParentheses.diffWaysToCompute("2-1-1");
        assertArrayEquals(new Integer[]{2, 0}, result.toArray());
    }

}