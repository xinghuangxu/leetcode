package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by xinghuangxu on 4/5/16.
 */
public class BestTimeToBuyAndSellStockWithCooldownTest extends TestCase {
    @Test
    public void test1() {
        BestTimeToBuyAndSellStockWithCooldown bestTimeToBuyAndSellStockWithCooldown = new BestTimeToBuyAndSellStockWithCooldown();
        int[] prices = {1,2,4};
        assertEquals(3, bestTimeToBuyAndSellStockWithCooldown.maxProfit(prices));
    }
}