package leetcode;

import java.util.HashSet;

/**
 * Created by xinghuangxu on 10/29/15.
 */
public class HappyNumber {

    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        while (!set.contains(n)) {
            if (n == 1) return true;
            set.add(n);
            int tmp = 0;
            while (n != 0) {
                tmp += Math.pow(n % 10, 2);
                n = n / 10;
            }
            n = tmp;
        }
        return false;
    }

}
