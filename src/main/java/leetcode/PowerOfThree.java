package leetcode;

/**
 * Created by k586j642 on 3/9/2016.
 */
public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        while (n % 3 == 0) {
            n = n / 3;
        }
        if (n != 1) return false;
        return true;
    }
}
