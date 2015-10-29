package leetcode;

/**
 * Created by xinghuangxu on 10/27/15.
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int sum = (nums.length * (nums.length + 1)) / 2;
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
        }
        return sum;
    }
}
