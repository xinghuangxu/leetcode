package leetcode;

/**
 * Created by xinghuangxu on 4/5/16.
 */
public class BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        int size = prices.length;
        if (size == 0) return 0;
        int[] sell = new int[size];
        int[] buy = new int[size];
        buy[0] = -prices[0];
        for (int i = 1; i < size; i++) {
            buy[i] = Math.max((i - 2 < 0 ? 0 : sell[i - 2]) - prices[i], buy[i - 1]);
            sell[i] = Math.max(buy[i - 1] + prices[i], sell[i - 1]);
        }
        return sell[size - 1];
    }
}
