package leetcode;

/**
 * Created by k586j642 on 3/9/2016.
 */
public class SearchForARange {

    public int[] searchRange(int[] nums, int target) {
        int[] ret = new int[]{-1, -1};
        //binary search find the first target
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int mid = (i + j) / 2; //bias towards the left so mid will always < j;
            if (nums[mid] > target) {
                j = mid - 1;
            } else if (nums[mid] == target) {
                j = mid; //will make progress because mid is bias towards the left so mid will always < j;
            } else {
                i = mid + 1;
            }
        }
        //find the right target
        if (nums[i] != target) return ret;
        ret[0] = i;
        j = nums.length - 1;
        while (i < j) {
            int mid = (i + j + 1) / 2; //bias towards the right
            if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid; //bias toward the right so mid will always >i thus progress is made
            }
        }
        ret[1] = i;
        return ret;
    }

}
