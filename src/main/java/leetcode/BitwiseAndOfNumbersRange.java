package leetcode;

/**
 * Created by xinghuangxu on 8/2/15.
 */
public class BitwiseAndOfNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        if (n == m) return m;
        if (m == 0) return m;
        for (int i = 30; i > -1; i--) {
            int num = 1 << i;
            if (m <= num && num <= n) {

                return 1 << i;

            }
        }
        int result = n;
        for (int i = n - 1; i >= m; i--) {
            if (result == 0) {
                return 0;
            }
            result = result & i;
        }
        return result;
    }
}
