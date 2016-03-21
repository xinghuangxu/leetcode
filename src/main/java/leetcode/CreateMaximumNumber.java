package leetcode;

/**
 * Created by xinghuangxu on 3/21/16.
 */
public class CreateMaximumNumber {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        return maxNumberSub(nums1, nums2, k, -1, -1);
    }

    private int[] maxNumberSub(int[] nums1, int[] nums2, int k, int firstStart, int secondStart) {
        int[] result = new int[k];
        int firstArrayMaxValue, secondArrayMaxValue;
        for (int i = 0; i < k; i++) {
            //find the max in the first array
            int maxIndexInFirstArray = findMaxInArrayWithStartingPointAndK(nums1, firstStart, k - nums2.length + secondStart + 1 - i);
            //find the max in the second array
            int maxIndexInSecondArray = findMaxInArrayWithStartingPointAndK(nums2, secondStart, k - nums1.length + firstStart + 1 - i);
            if (maxIndexInFirstArray == nums1.length) {
                firstArrayMaxValue = Integer.MIN_VALUE;
            } else {
                firstArrayMaxValue = nums1[maxIndexInFirstArray];
            }
            if (maxIndexInSecondArray == nums2.length) {
                secondArrayMaxValue = Integer.MIN_VALUE;
            } else {
                secondArrayMaxValue = nums2[maxIndexInSecondArray];
            }
            if (firstArrayMaxValue < secondArrayMaxValue) {
                secondStart = maxIndexInSecondArray;
                result[i] = secondArrayMaxValue;
            } else if (firstArrayMaxValue == secondArrayMaxValue) {
                int[] subResult1 = maxNumberSub(nums1, nums2, k - i - 1, firstStart, maxIndexInSecondArray);
                int[] subResult2 = maxNumberSub(nums1, nums2, k - i - 1, maxIndexInFirstArray, secondStart);
                int[] subResult = getBiggerArrayByComparing(subResult1, subResult2);
                result[i] = firstArrayMaxValue;
                for (int j = i + 1; j < k; j++) {
                    result[j] = subResult[j - i - 1];
                }
                return result;
            } else {
                firstStart = maxIndexInFirstArray;
                result[i] = firstArrayMaxValue;
            }
        }
        return result;
    }

    private int[] getBiggerArrayByComparing(int[] subResult1, int[] subResult2) {
        for (int i = 0; i < subResult1.length; i++) {
            if (subResult1[i] < subResult2[i]) {
                return subResult2;
            } else if (subResult1[i] > subResult2[i]) {
                return subResult1;
            }
        }
        return subResult1;
    }

    private int findMaxInArrayWithStartingPointAndK(int[] array, int startIndex, int k) {
        int length = array.length;
        int maxIndex = startIndex + 1;
        startIndex = startIndex + 2;
        while (length - startIndex >= k && startIndex < length) {
            if (array[startIndex] > array[maxIndex]) {
                maxIndex = startIndex;
            }
            startIndex++;
        }
        return maxIndex;
    }
}
