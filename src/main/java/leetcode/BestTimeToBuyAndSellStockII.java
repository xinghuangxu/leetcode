package leetcode;

/**
 * Created by xinghuangxu on 4/4/16.
 */
public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        int globalMax = 0;
        if (prices == null || prices.length == 0) return globalMax;
        int min = prices[0], max = min;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > max) {
                max = prices[i];
            } else {
                globalMax += (max - min);
                min = prices[i];
                max = prices[i];
            }
        }
        return globalMax + (max - min);
    }
}
