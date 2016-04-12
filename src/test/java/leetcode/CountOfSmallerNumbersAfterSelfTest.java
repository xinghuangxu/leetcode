package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

/**
 * Created by xinghuangxu on 3/30/16.
 */
public class CountOfSmallerNumbersAfterSelfTest extends TestCase {
    @Test
    public void test1() {
        CountOfSmallerNumbersAfterSelf countOfSmallerNumbersAfterSelf = new CountOfSmallerNumbersAfterSelf();
        int[] nums = {5, 2, 6, 1};
        List<Integer> result = countOfSmallerNumbersAfterSelf.countSmaller(nums);
    }

}