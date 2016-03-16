package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by k586j642 on 3/10/2016.
 */
public class CoinChangeTest extends TestCase {
    @Test
    public void test1() {
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;
        CoinChange coinChange = new CoinChange();
        int actual = coinChange.coinChange(coins, amount);
        assertEquals(3, actual);
    }

    @Test
    public void test2() {
        int[] coins = new int[]{2};
        int amount = 3;
        CoinChange coinChange = new CoinChange();
        int actual = coinChange.coinChange(coins, amount);
        assertEquals(-1, actual);
    }

    @Test
    public void test3() {
        int[] coins = new int[]{2,5,10,1};
        int amount = 27;
        CoinChange coinChange = new CoinChange();
        int actual = coinChange.coinChange(coins, amount);
        assertEquals(4, actual);
    }

    @Test
    public void test4() {
        int[] coins = new int[]{186,419,83,408};
        int amount = 6249;
        CoinChange coinChange = new CoinChange();
        int actual = coinChange.coinChange(coins, amount);
        assertEquals(20, actual);
    }
}