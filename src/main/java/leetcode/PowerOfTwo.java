package leetcode;

/**
 * Created by Xinghuang Leon Xu on 9/1/2015.
 */
public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        int d = n;
        while (d != 1) {
            if (d % 2 != 0 || d == 0) {
                return false;
            }
            d = d >> 1;
        }
        return true;
    }

    public boolean isPowerOfTwo2(int n) {
        int comp = 1;
        for (int i = 0; i < 31; i++) {
            if (n == comp) return true;
            comp = comp << 1;
        }
        return false;
    }
}
