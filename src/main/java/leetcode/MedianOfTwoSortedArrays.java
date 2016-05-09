package leetcode;

/**
 * Created by xinghuangxu on 4/19/16.
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size1 = nums1.length, size2 = nums2.length;
        int first = findKthValue(nums1, 0, size1 - 1, nums2, 0, size2 - 1, 1+ ((size1 + size2) / 2));
        if (((size1 + size2) % 2) == 0) {
            return ((double) first + findKthValue(nums1, 0, size1 - 1, nums2, 0, size2 - 1, (size1 + size2) / 2)) / 2.0;
        } else {
            return first;
        }
    }

    //find the kth number in the array
    private int findKthValue(int[] nums1, int l1, int h1, int[] nums2, int l2, int h2, int k) {
        //Assume nums1 is bigger than nums2
        int size1 = h1 - l1 + 1, size2 = h2 - l2 + 1;
        if (size1 < size2) {
            return findKthValue(nums2, l2, h2, nums1, l1, h1, k);
        }
        if (size2 <= 0) {
            return nums1[l1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[l1], nums2[l2]);
        }
        int i = Math.min(size1, k / 2);
        int j = Math.min(size2, k / 2);
        if (nums1[l1 + i - 1] > nums2[l2 + j - 1]) {
            return findKthValue(nums1, l1, h1, nums2, l2 + j, h2, k - j);
        } else {
            return findKthValue(nums1, l1 + i, h1, nums2, l2, h2, k - i);
        }
    }
}
