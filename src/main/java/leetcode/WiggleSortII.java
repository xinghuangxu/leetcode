package leetcode;

/**
 * Created by k586j642 on 3/10/2016.
 */
public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        //partition the element into two half
        findKthElement(nums, 0, nums.length, nums.length / 2);

        //swap first half with the second half
    }

    private void findKthElement(int[] nums,int lo,int hi,int k) {


    }
}
