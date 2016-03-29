package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by k586j642 on 3/29/2016.
 */
public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        List<Integer> uglyNumberList = new ArrayList<Integer>();
        uglyNumberList.add(1);
        n--;
        int k = primes.length;
        int[] pointers = new int[k];
        while (n != 0) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < k; i++) {
                if (min > uglyNumberList.get(pointers[i]) * primes[i]) {
                    min = uglyNumberList.get(pointers[i]) * primes[i];
                }
            }

            for (int i = 0; i < k; i++) {
                if (min == uglyNumberList.get(pointers[i]) * primes[i]) {
                    pointers[i]++;
                }
            }
            uglyNumberList.add(min);
            n--;
        }
        return uglyNumberList.get(uglyNumberList.size() - 1);
    }
}
