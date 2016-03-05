package leetcode;


/**
 * Created by k586j642 on 2/29/2016.

 */
public class PatchingArray {

    public int minPatches(int[] nums, int n) {
        int count = 0;
        long coveredArea = 0; //long in case big integer
        int i = 0;
        while (coveredArea < n ) {
            if (i<nums.length && coveredArea + 1 >= nums[i]) {
                coveredArea += nums[i];
                i++;
            } else {
                count++;
                coveredArea += coveredArea + 1;
            }
        }
        return count;
    }

    public int minPatches2(int[] nums, int n) {
        boolean[] records = new boolean[n + 1];
        for (int i = 0; i < nums.length; i++) {
            addNum(records, n, nums[i]);
        }
        int times = 0;
        for (int i = 1; i <= n; i++) {
            if (!records[i]) {
                addNum(records, n, i);
                times++;
            }
        }
        return times;
    }

    private void addNum(boolean[] records, int cap, int addedNum) {
        for (int i = cap - addedNum; i >= 1; i--) {
            if (records[i] && !records[i + addedNum]) {
                records[i + addedNum] = true;
            }
        }
        if (!records[addedNum]) {
            records[addedNum] = true;
        }
    }
}
