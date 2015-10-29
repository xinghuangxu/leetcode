package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Xinghuang Leon Xu on 10/29/2015.
 */
public class StringNumberIII {
    public int[] singleNumber1(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        int[] result = new int[2];
        int t = 0;
        for (Integer i : set) {
            result[t] = i;
            t++;
        }
        return result;
    }

    /*
    Constant space solution
     */
    public int[] singleNumber(int[] nums) {
        int xXorY = 0;
        for (int i : nums) {
            xXorY ^= i;
        }
        int lastOneBit = xXorY & (~(xXorY - 1));
        int x = 0;
        for (int i : nums) {
            if ((i & lastOneBit) != 0) {
                x ^= i;
            }
        }
        int y = x ^ xXorY;
        return new int[]{x, y};
    }
}
