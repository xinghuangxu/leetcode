package other;

/**
 * Created by k586j642 on 3/10/2016.
 */
public class DutchNationalFlagProblem {
    /**
     * Sort an array of 0s, 1s and 2s
     * Given an array A[] consisting 0s, 1s and 2s, write a function that sorts A[]. The functions should put all 0s first, then all 1s and all 2s in last.
     * <p>
     * Example
     * Input = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
     * Output = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}
     */
    public void segregate0and1(int[] nums) {
        int lo = 0, mid = 0, hi = nums.length - 1;
        while(mid<=hi){
            if(nums[mid]==0){
                swap(nums,mid,lo);
                lo++;
                mid++;
            }else if(nums[mid]==1){
                mid++;
            }else{
                swap(nums,mid,hi);
                hi--;
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }
}
