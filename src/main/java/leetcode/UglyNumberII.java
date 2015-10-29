package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xinghuang Leon Xu on 10/26/2015.
 */
public class UglyNumberII {
    public int nthUglyNumber(int n) {
        List<Integer> uglyNums = new ArrayList();
        uglyNums.add(1);
        int r1 = 0, r2 = 0, r3 = 0, min, num;
        for (int i = 0; i < n - 1; i++) {
            int c1 = uglyNums.get(r1) * 2, c2 = uglyNums.get(r2) * 3, c3 = uglyNums.get(r3) * 5;
            min = Math.min(c1, Math.min(c2, c3));
            if (min == c1) {
                r1++;
            }
            if (min == c2) {
                r2++;
            }
            if (min == c3) {
                r3++;
            }
            uglyNums.add(min);
        }
        return uglyNums.get(n - 1);
    }
}
