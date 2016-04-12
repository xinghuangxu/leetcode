package leetcode;

import java.util.*;

/**
 * Created by k586j642 on 4/6/2016.
 */
public class FourSum {

    Set<List<Integer>> map = new HashSet();

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();
        if (nums == null || nums.length < 4) return result;
        for (int i = 3; i < nums.length; i++) {
            List<List<Integer>> threeSums = threeSum(nums, 0, i - 1, target - nums[i]);
            for (List<Integer> list : threeSums) {
                list.add(nums[i]);
                if (!map.contains(list)) {
                    map.add(list);
                    result.add(list);
                }
            }
        }
        return result;
    }


    public List<List<Integer>> threeSum(int[] nums, int lo, int hi, int target) {
        List<List<Integer>> result = new ArrayList();
        int first, second, third;
        int i = 2;
        while (i <= hi) {
            third = nums[i];
            int left = lo, right = i - 1;
            while (right > left) {
                first = nums[left];
                second = nums[right];
                if (first + second + third == target) {
                    //move two pointers
                    left++;
                    right--;
                    List<Integer> tmpList = new ArrayList(3);
                    tmpList.add(first);
                    tmpList.add(second);
                    tmpList.add(third);
                    result.add(tmpList);
                } else if (first + second + third < target) {
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
