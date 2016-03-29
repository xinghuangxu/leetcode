package leetcode;

/**
 * Created by k586j642 on 3/25/2016.
 */
public class LongestIncreasingSubsequence {
    // http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
    //solution with nlg(n)



    //solution with n*n complexity
    public int lengthOfLIS(int[] nums) {
        int[] lISBefore = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && lISBefore[j] > max) {
                    max = lISBefore[j];
                }
            }
            lISBefore[i] = max + 1;
        }
        int maxLIS = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (maxLIS < lISBefore[i]) {
                maxLIS = lISBefore[i];
            }
        }
        return maxLIS;
    }
}
