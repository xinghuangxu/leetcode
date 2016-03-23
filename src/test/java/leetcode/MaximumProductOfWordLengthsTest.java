package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by xinghuangxu on 3/23/16.
 */
public class MaximumProductOfWordLengthsTest extends TestCase {

    @Test
    public void test1() {
        MaximumProductOfWordLengths maximumProductOfWordLengths = new MaximumProductOfWordLengths();
        String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        assertEquals(16, maximumProductOfWordLengths.maxProduct(words));
    }

    @Test
    public void test2() {
        MaximumProductOfWordLengths maximumProductOfWordLengths = new MaximumProductOfWordLengths();
        String[] words = {"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
        assertEquals(4, maximumProductOfWordLengths.maxProduct(words));
    }


    @Test
    public void test3() {
        MaximumProductOfWordLengths maximumProductOfWordLengths = new MaximumProductOfWordLengths();
        String[] words = {"a", "aa", "aaa", "aaaa"};
        assertEquals(0, maximumProductOfWordLengths.maxProduct(words));
    }


}