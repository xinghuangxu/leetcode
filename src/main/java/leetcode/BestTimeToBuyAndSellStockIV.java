package leetcode;

import java.util.*;

/**
 * Created by xinghuangxu on 4/4/16.
 */
public class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        if (k < 1) return 0;
        List<Integer> gap = new ArrayList();
        int maxProfit = getManyBuyMaxProfit(prices, gap);
        int transactionCount = gap.size() + 1;
        Collections.sort(gap);
        for (int i = 0; transactionCount - i > k; i++) {
            maxProfit -= gap.get(i);
        }
        return maxProfit;
    }


    private int getManyBuyMaxProfit(int[] prices, List<Integer> gap) {
        int globalMax = 0;
        if (prices == null || prices.length == 0) return globalMax;
        int min = prices[0], max = min;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > max) {
                max = prices[i];
            } else {
                gap.add(max - prices[i]);
                globalMax += (max - min);
                min = prices[i];
                max = prices[i];
            }
        }
        return globalMax + (max - min);
    }
}
