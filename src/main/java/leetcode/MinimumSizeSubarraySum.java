package leetcode;

/**
 * Created by xinghuangxu on 8/18/15.
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0)return 0;
        int length= findMinSubArrayLen(0, nums.length-1, nums, s);
        if(length==Integer.MAX_VALUE)return 0;
        return length;
    }

    private int findMinSubArrayLen(int start, int end, int[] nums, int s) {
        if (end == start) {
            if (nums[start] >= s) return 1;
            else return Integer.MAX_VALUE;
        }
        int mid = (end + start) / 2;
        int leftMinSubArrayLen = findMinSubArrayLen(start, mid, nums, s);
        int rightMinSubArrayLen = findMinSubArrayLen(mid + 1, end, nums, s);
        int midMinSubArrayLen = findCrossMinSubArrayLen(start, end, mid, nums, s);
        return Math.min(midMinSubArrayLen, Math.min(leftMinSubArrayLen, rightMinSubArrayLen));
    }

    private int findCrossMinSubArrayLen(int start, int end, int mid, int[] nums, int s) {
        int val = nums[mid] + nums[mid + 1];
        int length = 2;
        if (s <= val) return length;
        int curLeft = mid - 1;
        int curRight = mid + 2;
        while (curLeft >= start && curRight <= end) {
            if (nums[curLeft] > nums[curRight]) {
                val += nums[curLeft];
                curLeft--;
            } else {
                val += nums[curRight];
                curRight++;
            }
            length++;
            if (s <= val) return length;
        }
        while (curLeft >= start) {
            val += nums[curLeft];
            curLeft--;
            length++;
            if (s <= val) return length;
        }
        while (curRight <= end) {
            val += nums[curRight];
            curRight++;
            length++;
            if (s <= val) return length;
        }
        return Integer.MAX_VALUE;
    }
}
