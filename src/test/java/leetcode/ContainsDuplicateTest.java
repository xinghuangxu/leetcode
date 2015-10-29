package leetcode;

import helper.TreeNode;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by Xinghuang Leon Xu on 10/29/2015.
 */
public class ContainsDuplicateTest extends TestCase {
    @Test
    public void test1() {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        int size = 30000;
        int[] nums = new int[size];
        for(int i=0;i<30000;i++){
            nums[i]=i;
        }
        assertEquals(false, containsDuplicate.containsDuplicate(nums));
    }
}