package leetcode;

import java.util.Arrays;

/**
 * Created by k586j642 on 3/10/2016.
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] change = new int[amount + 1];
        change[0] = 0;
        for (int i = 1; i < coins.length; i++) {
            if (coins[i] <= amount) {
                change[coins[i]] = 1;
            }
        }
        for (int i = 1; i <= amount; i++) {
            if (change[i] != 1) {
                change[i] = Integer.MAX_VALUE;
            }
        }

        for (int c = 1; c <= amount; c++) {
            for (int i = 0; i < coins.length; i++) {
                if (coins[i] <= c && change[c - coins[i]] != Integer.MAX_VALUE) {
                    if (change[c - coins[i]] + 1 < change[c]) {
                        change[c] = change[c - coins[i]] + 1;
                    }
                }
            }
        }

        if (change[amount] == Integer.MAX_VALUE) return -1;
        return change[amount];
    }


    // Should use dynamic programming
//    public int coinChange(int[] coins, int amount) {
//        Arrays.sort(coins);
//        return getCoinChangeAmount(coins, amount, coins.length - 1);
//    }
//
//    private int getCoinChangeAmount(int[] coins, int amount, int i) {
//        int currentMin = Integer.MAX_VALUE;
//        if (i == 0) {
//            if (amount % coins[i] != 0) {
//                return -1;
//            } else {
//                return amount / coins[i];
//            }
//        }
//        if (amount % coins[i] == 0) {
//            return amount / coins[i];
//        } else {
//            int count = amount / coins[i];
//            while (count != -1) {
//                int tmp = getCoinChangeAmount(coins, amount - count * coins[i], i - 1);
//                if (tmp != -1 && tmp + count < currentMin) {
//                    currentMin = count + tmp;
//                } else {
//                    count--;
//                }
//            }
//        }
//        if (currentMin != Integer.MAX_VALUE) {
//            return currentMin;
//        }
//        return -1;
//    }
}
