package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by Xinghuang Leon Xu on 9/3/2015.
 */
public class ProductOfArrayExceptSelfTest extends TestCase {

    @Test
    public void test1() {
        int[] nums = {1, 2, 3, 4};
        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        productOfArrayExceptSelf.productExceptSelf(nums);
        int[] actual = productOfArrayExceptSelf.productExceptSelf(nums);
        assertArrayEquals(new int[]{24, 12, 8, 6}, actual);
    }


}