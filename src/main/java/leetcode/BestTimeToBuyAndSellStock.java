package leetcode;

/**
 * Created by xinghuangxu on 4/4/16.
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int globalMax = 0;

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > max) {
                max = prices[i];
            }
            if (prices[i] < min) {
                min = prices[i];
                max = prices[i];
            }
            globalMax = Math.max(globalMax, max - min);
        }
        return globalMax;
    }


}
