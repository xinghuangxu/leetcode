package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by xinghuangxu on 4/4/16.
 */
public class BestTimeToBuyAndSellStockIIITest extends TestCase {

    @Test
    public void test1() {
        BestTimeToBuyAndSellStockIII bestTimeToBuyAndSellStockIII = new BestTimeToBuyAndSellStockIII();
        int[] prices = {1};
        assertEquals(0, bestTimeToBuyAndSellStockIII.maxProfit(prices));
    }

    @Test
    public void test2() {
        BestTimeToBuyAndSellStockIII bestTimeToBuyAndSellStockIII = new BestTimeToBuyAndSellStockIII();
        int[] prices = {1,2};
        assertEquals(1, bestTimeToBuyAndSellStockIII.maxProfit(prices));
    }
}