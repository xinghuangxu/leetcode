package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by k586j642 on 3/10/2016.
 */
public class WiggleSortIITest extends TestCase {
    @Test
    public void test1(){
        WiggleSortII wiggleSortII = new WiggleSortII();
        int[] nums = new int[]{1, 5, 1, 1, 6, 4};
        wiggleSortII.wiggleSort(nums);
        for(int i=0;i+1<nums.length;i=i+2){
            assertTrue(nums[i]<nums[i+1]);
        }
    }

    //[1,3,2,2,3,1]
    @Test
    public void test2(){
        WiggleSortII wiggleSortII = new WiggleSortII();
        int[] nums = new int[]{1,3,2,2,3,1};
        wiggleSortII.wiggleSort(nums);
        for(int i=0;i+1<nums.length;i=i+2){
            assertTrue(nums[i]<nums[i+1]);
        }
    }
}