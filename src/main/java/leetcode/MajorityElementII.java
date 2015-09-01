package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xinghuang Leon Xu on 9/1/2015.
 */
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList();
        int k = 3;
        int[] counts = new int[k];
        Integer[] spots = new Integer[k];
        //first pass
        for (int i = 0; i < nums.length; i++) {
            boolean set = false;
            Integer current = nums[i];
            for (int j = 0; j < k; j++) {
                if (current.equals(spots[j])) {
                    counts[j]++;
                    set = true;
                    break;
                }
            }
            if (!set) {
                for (int j = 0; j < k; j++) {
                    if (counts[j] == 0) {
                        counts[j] = 1;
                        spots[j] = current;
                        set = true;
                        break;
                    }
                }
            }
            if (!set) {
                for (int j = 0; j < k; j++) {
                    counts[j]--;
                }
            }
        }
        //second pass
        counts = new int[k];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < k; j++) {
                if (nums[i] == spots[j]) {
                    counts[j]++;
                    break;
                }
            }
        }
        for (int j = 0; j < k; j++) {
            if (counts[j] > nums.length / 3) {
                result.add(spots[j]);
            }
        }
        return result;
    }
}
