package leetcode;

/**
 * Created by Xinghuang Leon Xu on 10/29/2015.
 */
public class AddDigits {
    public int addDigits(int num) {
        while (num > 9) {
            int nnum = 0;
            while (num != 0) {
                nnum += num % 10;
                num = num / 10;
            }
            num = nnum;
        }
        return num;
    }
}
