package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by xinghuangxu on 4/4/16.
 */
public class BestTimeToBuyAndSellStockIVTest extends TestCase {

    @Test
    public void test1() {
        BestTimeToBuyAndSellStockIV bestTimeToBuyAndSellStockIV = new BestTimeToBuyAndSellStockIV();
        int[] prices = {1,2};
        assertEquals(0, bestTimeToBuyAndSellStockIV.maxProfit(0, prices));
    }


    @Test
    public void test2() {
        BestTimeToBuyAndSellStockIV bestTimeToBuyAndSellStockIV = new BestTimeToBuyAndSellStockIV();
        int[] prices = {1,2};
        assertEquals(1, bestTimeToBuyAndSellStockIV.maxProfit(1, prices));
    }

    @Test
    public void test3() {
        BestTimeToBuyAndSellStockIV bestTimeToBuyAndSellStockIV = new BestTimeToBuyAndSellStockIV();
        int[] prices = {1,4,2,7};
        assertEquals(8, bestTimeToBuyAndSellStockIV.maxProfit(2, prices));
    }

    @Test
    public void test4() {
        BestTimeToBuyAndSellStockIV bestTimeToBuyAndSellStockIV = new BestTimeToBuyAndSellStockIV();
        int[] prices = {1,4,2,7};
        assertEquals(6, bestTimeToBuyAndSellStockIV.maxProfit(1, prices));
    }

    @Test
    public void test5() {
        BestTimeToBuyAndSellStockIV bestTimeToBuyAndSellStockIV = new BestTimeToBuyAndSellStockIV();
        int[] prices = {2,1};
        assertEquals(0, bestTimeToBuyAndSellStockIV.maxProfit(1, prices));
    }
}