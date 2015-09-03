package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Xinghuang Leon Xu on 9/2/2015.
 */
public class NumberOfDigitOne {

    public int countDigitOne(int n) {
        if (n <= 0) return 0;
        int count = 0;
        Map<Integer, Integer> mem = new HashMap<Integer, Integer>();
        int value = 9;
        int current = 1;
        mem.put(0, 0);
        int prev;
        while (value < n) {
            mem.put(value, current);
            value = value * 10 + 9;
            prev = current;
            current = prev * 10 + (value + 1) / 10;
        }
        String num = n + "";
        int length = num.length();
        int left = n;
        while (length != 0) {
            int currentDigit = num.charAt(num.length() - length) - '0';
            int tailingZeros = (int) Math.pow(10, length - 1);
            left = left - currentDigit * tailingZeros;
            count += mem.get(tailingZeros - 1) * currentDigit;
            if (currentDigit > 1) {
                count += tailingZeros;
            } else if (currentDigit == 1) {
                count += left + 1;
            }
            length--;
        }
        return count;
    }

//    public int countDigitOne(int n) {
//        count = 0;
//        for (int i = 1; i <= n; i++) {
//            sb.append(i);
//            accumulate(1000);
//        }
//        accumulate(0);
//        return count;
//    }
//
//    private void accumulate(int limit) {
//        if (sb.length() > limit) {
//            for (int j = 0; j < sb.length(); j++) {
//                if (sb.charAt(j) == '1') {
//                    count++;
//                }
//            }
//            sb = new StringBuilder();
//        }
//    }
}
