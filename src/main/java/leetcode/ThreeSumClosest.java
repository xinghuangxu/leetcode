package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by k586j642 on 4/6/2016.
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int minDiv = Integer.MAX_VALUE;
        int result = 0;
        Arrays.sort(nums);

        int first, second, third;
        int i = 2;
        while (i < nums.length) {
            third = nums[i];
            int left = 0, right = i - 1;
            while (right > left) {
                first = nums[left];
                second = nums[right];
                int tmpDiv = first + second + third - target;
                int absDiv = Math.abs(tmpDiv);
                if (absDiv < minDiv) {
                    minDiv = absDiv;
                    result = first + second + third;
                }
                if (tmpDiv == 0) {
                    return target;
                } else if (tmpDiv < 0) {
                    left++;
                } else {
                    right--;
                }
            }
            i++;
        }
        return result;
    }
}
