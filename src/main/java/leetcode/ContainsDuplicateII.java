package leetcode;

import java.util.HashMap;

/**
 * Created by Xinghuang Leon Xu on 10/29/2015.
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> valueIndexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (valueIndexMap.containsKey(nums[i]) && i - valueIndexMap.get(nums[i]) <= k) {
                return true;
            }
            valueIndexMap.put(nums[i], i);
        }
        return false;
    }

}
