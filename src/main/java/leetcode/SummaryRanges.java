package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xinghuang Leon Xu on 9/4/2015.
 */
public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if(nums==null || nums.length==0)return result;
        int start = nums[0];
        int end = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (end + 1 != nums[i]) {
                if (start == end) {
                    result.add(start + "");
                } else {
                    result.add(start + "->" + end);
                }
                start = end = nums[i];
            } else {
                end++;
            }
        }
        if (start == end) {
            result.add(start + "");
        } else {
            result.add(start + "->" + end);
        }
        return result;
    }
}
