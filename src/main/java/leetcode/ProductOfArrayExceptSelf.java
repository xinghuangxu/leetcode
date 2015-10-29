package leetcode;

/**
 * Created by Xinghuang Leon Xu on 9/3/2015.
 */
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] products = new int[length];
        products[0] = nums[0];
        for (int i = 1; i < length - 1; i++) {
            products[i] = products[i - 1] * nums[i];
        }
        int reverseProduct = 1;
        products[length - 1] = reverseProduct;
        for (int i = length - 1; i > 0; i--) {
            products[i] = reverseProduct * products[i - 1];
            reverseProduct = reverseProduct * nums[i];
        }
        products[0] = reverseProduct;
        return products;
    }
}
