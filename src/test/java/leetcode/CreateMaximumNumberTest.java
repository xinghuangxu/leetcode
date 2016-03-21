package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by xinghuangxu on 3/21/16.
 */
public class CreateMaximumNumberTest extends TestCase {
    /*
    nums1 = [3, 4, 6, 5]
nums2 = [9, 1, 2, 5, 8, 3]
k = 5
return [9, 8, 6, 5, 3]
     */
    @Test
    public void test1() {
        CreateMaximumNumber createMaximumNumber = new CreateMaximumNumber();
        int[] num1 = new int[]{3, 4, 6, 5};
        int[] nums2 = new int[]{9, 1, 2, 5, 8, 3};
        int k = 5;
        assertArrayEquals(new int[]{9, 8, 6, 5, 3}, createMaximumNumber.maxNumber(num1, nums2, k));
    }

    /*
    nums1 = [3, 9]
nums2 = [8, 9]
k = 3
return [9, 8, 9]


     */
    @Test
    public void test2() {
        CreateMaximumNumber createMaximumNumber = new CreateMaximumNumber();
        int[] num1 = new int[]{3, 9};
        int[] nums2 = new int[]{8, 9};
        int k = 3;
        assertArrayEquals(new int[]{9, 8, 9}, createMaximumNumber.maxNumber(num1, nums2, k));
    }

    /*
    Example 2:
nums1 = [6, 7]
nums2 = [6, 0, 4]
k = 5
return [6, 7, 6, 0, 4]
     */
    @Test
    public void test3() {
        CreateMaximumNumber createMaximumNumber = new CreateMaximumNumber();
        int[] num1 = new int[]{6,7};
        int[] nums2 = new int[]{6,0,4};
        int k = 5;
        assertArrayEquals(new int[]{6,7,6,0,4}, createMaximumNumber.maxNumber(num1, nums2, k));
    }
}