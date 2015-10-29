package leetcode;

/**
 * Created by Xinghuang Leon Xu on 10/29/2015.
 */
public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] num = new boolean[n];
        for (int i = 2; i * i < n; i++) {
            if (!num[i]) {
                for (int j = i * i; j < n; j += i) {
                    num[j] = true;
                }
            }
        }
        int result = 0;
        for (int i = 2; i < n; i++) {
            if (!num[i]) {
                result++;
            }
        }
        return result;
    }
}
