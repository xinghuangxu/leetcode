package leetcode;

/**
 * Created by xinghuangxu on 4/17/16.
 */
public class Candy {


    public int candy(int[] ratings) {
        int size = ratings.length;
        if (size == 0) return 0;

        int[] candies = new int[size];
        for (int i = 1; i < size; i++) {
            if (ratings[i] > ratings[i - 1]) {
                if (candies[i] <= candies[i - 1]) {
                    candies[i] = candies[i - 1] + 1;

                }
            }

        }
        for (int i = size - 2; i > -1; i--) {
            if (ratings[i] > ratings[i + 1]) {
                if (candies[i] <= candies[i + 1]) {
                    candies[i] = candies[i + 1] + 1;
                }
            }
        }

        int result = size;
        for (int i = 0; i < size; i++) {
            result += candies[i];
        }
        return result;
    }
}
