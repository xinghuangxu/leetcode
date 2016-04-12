package leetcode;

/**
 * Created by xinghuangxu on 4/4/16.
 */
public class BestTimeToBuyAndSellStockIII {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int[] forward = maxProfitInRange(prices);
        int[] backward = maxProfitInRangeBackWard(prices);
        int globalMax = backward[0];
        for (int i = 1; i < prices.length - 2; i++) {
            globalMax = Math.max(forward[i] + backward[i + 1], globalMax);
        }
        return globalMax;
    }

    private int[] maxProfitInRangeBackWard(int[] prices) {
        int globalMin = 0;
        int[] result = new int[prices.length];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = prices.length - 1; i > -1; i--) {
            if (prices[i] < min) {
                min = prices[i];
            }
            if (prices[i] > max) {
                min = prices[i];
                max = prices[i];
            }
            globalMin = Math.max(globalMin, max - min);
            result[i] = globalMin;
        }
        return result;
    }

    private int[] maxProfitInRange(int[] prices) {
        int globalMax = 0;
        int[] result = new int[prices.length];
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
            result[i] = globalMax;
        }
        return result;
    }
}
