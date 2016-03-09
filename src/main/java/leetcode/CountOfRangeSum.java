package leetcode;

/**
 * Created by xinghuangxu on 3/9/16.
 */
public class CountOfRangeSum {

    class PrefixNode{
        int index;
        int value;
    }

    //nlogn algorithm
    int count;

    public int countRangeSum(int[] nums, int lower, int upper) {
        count = 0;
        int length = nums.length;
        if (length == 0) return count;
        int[] prefixSums = new int[length];

        prefixSums[0] = nums[0];
        increaseCountIfInRange(prefixSums[0], lower, upper);
        for (int i = 1; i < length; i++) {
            prefixSums[i] = prefixSums[i - 1] + nums[i];
            increaseCountIfInRange(prefixSums[i], lower, upper);
        }
        for (int i = 0; i < length - 1; i++) {
            findPrefixSumInRange(prefixSums,lower,upper,i);

        }
        return count;
    }

    private void findPrefixSumInRange(int[] prefixSums, int lower, int upper, int i) {
        binarySearchIncreaseCountIfInRange(prefixSums, lower+prefixSums[i], upper+prefixSums[i]);
    }

    private void increaseCountIfInRange(int num, int lower, int upper) {
        if (num >= lower && num <= upper) {
            count++;
        }
    }


    //n^2 algorithm:

//    int count;
//
//    public int countRangeSum(int[] nums, int lower, int upper) {
//        count = 0;
//        int length = nums.length;
//        if (length == 0) return count;
//        int[] partialSumArray = new int[length];
//
//        partialSumArray[0] = nums[0];
//        increaseCountIfInRange(partialSumArray[0], lower, upper);
//        for (int i = 1; i < length; i++) {
//            partialSumArray[i] = partialSumArray[i - 1] + nums[i];
//            increaseCountIfInRange(partialSumArray[i], lower, upper);
//        }
//        for (int i = 0; i < length - 1; i++) {
//
//            for (int j = i + 1; j < length; j++) {
//                partialSumArray[j] -= nums[i];
//                increaseCountIfInRange(partialSumArray[j], lower, upper);
//            }
//        }
//        return count;
//    }
//
//    private void increaseCountIfInRange(int num, int lower, int upper) {
//        if (num >= lower && num <= upper) {
//            count++;
//        }
//    }
}
