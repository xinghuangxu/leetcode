package leetcode;

/**
 * Created by xinghuangxu on 3/30/16.
 */
public class BurstBalloons {
    public int maxCoins(int[] nums) {
        int[] values = new int[nums.length + 2];
        for (int i = 0; i < nums.length; i++) {
            values[i + 1] = nums[i];
        }
        values[0] = 1;
        values[values.length - 1] = 1;

        int[][] dp = new int[nums.length + 1][nums.length + 1];
        //the gap goes from 0 to 4
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j + i <= nums.length; j++) {
                int max = Integer.MIN_VALUE;
                //range from j to j+i
                for (int k = j; k < j + i; k++) {
                    max = Math.max(max, dp[j][k] + dp[k + 1][j + i] + values[j] * values[k + 1] * values[j + i + 1]);
                }
                dp[j][j + i] = max;
            }
        }
        return dp[0][nums.length];
    }
}
