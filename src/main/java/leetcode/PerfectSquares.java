package leetcode;

import java.util.*;

/**
 * Created by Xinghuang Leon Xu on 10/30/2015.
 */
public class PerfectSquares {

    public int numSquares(int n) {
        List<Integer> squareNums = new ArrayList();
        for(int i=1; (i-1)*(i-1)<=n;i++){
            squareNums.add(i*i);
        }
        int[] dp = new int[n+1];
        for(int i=1;i<=n;i++){
            int min = Integer.MAX_VALUE;
            for(int j=0;squareNums.get(j)<=i;j++){
                min = Math.min(min, 1+dp[i-squareNums.get(j)]);
            }
            dp[i]=min;
        }
        return dp[n];
    }

    public int numSquares2(int n) {
        int[] nums = new int[n + 1];
        for (int i = 1; i * i <= n; i++) {
            nums[i * i] = 1;
        }
        if (nums[n] != 0) return 1;
        for (int i = 2; i <= n; i++) {
            if (nums[i] == 0) {
                nums[i] = Integer.MAX_VALUE;
                int min, m = 1, k = i - 1;
                while (m <= k) {
                    min = nums[m] + nums[k];
                    if (min < nums[i]) {
                        nums[i] = min;
                    }
                    m++;
                    k--;
                }
            }
        }
        return nums[n];
    }
}
