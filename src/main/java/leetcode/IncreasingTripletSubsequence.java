package leetcode;

/**
 * Created by k586j642 on 2/26/2016.
 */
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= min) {
                min = n;
            } else if (n < secondMin) {
                secondMin = n;
            } else if (n > secondMin) {
                return true;
            }
        }
        return false;
    }

    public boolean increasingTriplet2(int[] nums) {
        if (nums.length <= 2) return false;
        Integer sm1 = nums[0];
        Integer sm2 = null, minimumSoFar = null, min2 = null;
        int i = 1;
        while (sm2 == null && i < nums.length) {
            if (nums[i] <= sm1) {
                sm1 = nums[i];
            } else {
                sm2 = nums[i];
            }
            i++;
        }
        if (i == nums.length) return false;
        minimumSoFar = sm1;
        for (; i < nums.length; i++) {
            if (nums[i] > sm2) {
                return true;
            } else {
                if (nums[i] > sm1) {
                    sm2 = nums[i];
                } else {
                    if (minimumSoFar > nums[i]) {
                        minimumSoFar = nums[i];
                    } else if (minimumSoFar != nums[i]) {
                        sm1 = minimumSoFar;
                        sm2 = nums[i];
                    }
                }
            }
        }
        return false;
    }
}
