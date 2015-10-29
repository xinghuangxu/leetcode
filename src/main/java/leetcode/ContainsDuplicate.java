package leetcode;

import java.util.HashSet;

/**
 * Created by Xinghuang Leon Xu on 10/29/2015.
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int i : nums) {
            if (hashSet.contains(i)) {
                return true;
            }
            hashSet.add(i);
        }
        return false;
    }
}
