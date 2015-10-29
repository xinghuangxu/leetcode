package leetcode;

/**
 * Created by Xinghuang Leon Xu on 10/29/2015.
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        for (int i = length - 1; i > -1; i--) {
            if (nums[i] == 0) {
                int tmp = i + 1;
                while (tmp < length && nums[tmp] != 0) {
                    nums[tmp - 1] = nums[tmp];
                    tmp++;
                }
                nums[tmp - 1] = 0;
            }
        }
    }
}
