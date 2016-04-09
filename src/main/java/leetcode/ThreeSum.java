package leetcode;

import java.util.*;

/**
 * Created by k586j642 on 4/6/2016.
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        if (nums == null || nums.length < 3) return result;

        Arrays.sort(nums);

        int first, second, third;
        int i = 2;
        while (i < nums.length) {
            third = nums[i];
            while (i < nums.length - 1 && nums[i + 1] == third) {
                i++;
            }
            int left = 0, right = i - 1;
            while (right > left) {
                first = nums[left];
                second = nums[right];
                if (first + second + third == 0) {
                    //move two pointers
                    while (left < nums.length && nums[left] == first) {
                        left++;
                    }
                    while (right > -1 && nums[right] == second) {
                        right--;
                    }
                    List<Integer> tmpList = new ArrayList(3);
                    tmpList.add(first);
                    tmpList.add(second);
                    tmpList.add(third);
                    result.add(tmpList);
                } else if (first + second + third < 0) {
                    while (left < nums.length && nums[left] == first) {
                        left++;
                    }
                } else {
                    while (right > -1 && nums[right] == second) {
                        right--;
                    }
                }
            }
            i++;
        }
        return result;
    }
}
