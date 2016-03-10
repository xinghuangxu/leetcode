package leetcode;

import java.util.Random;

/**
 * Created by k586j642 on 3/10/2016.
 */
public class WiggleSortII {
    Random rand = new Random();

    public void wiggleSort(int[] nums) {
        //partition the element into two half
        findKthElement(nums, 0, nums.length - 1, nums.length / 2);

        //swap first half with the second half
        for (int i = 1; i < nums.length / 2; i=i+2) {
            swap(nums, i, i + nums.length / 2);
        }
    }

    private void swap(int[] nums, int n1, int n2) {
        int tmp = nums[n1];
        nums[n1] = nums[n2];
        nums[n2] = tmp;
    }

//    private void findKthElement(int[] nums, int lo, int hi, int k) {
//        int randomNumber = rand.nextInt(hi - lo + 1) + lo;
//        swap(nums, randomNumber, hi);
//        int leftSize = partition(nums, lo, hi);
//        if (leftSize > k) {
//            findKthElement(nums, lo, lo + leftSize - 1, k);
//        } else if (leftSize < k) {
//            findKthElement(nums, lo + leftSize, hi, k - leftSize);
//        }
//
//    }

//    //return number of elements smaller than nums[hi]
//    private int partition(int[] nums, int lo, int hi) {
//        //always pick the last element as pivot
//        int pivot = nums[hi];
//        int i = lo, j = hi - 1;
//        while (i < j) {
//            if (nums[i] >= pivot) {
//                swap(nums, i, j);
//                j--;
//            } else {
//                i++;
//            }
//        }
//        if (nums[i] >= pivot) {
//            return i;
//        } else {
//            return i + 1;
//        }
//    }


    private int findKthElement(int[] arr, int l, int r, int k) {

        // Partition the array around a random element and
        // get position of pivot element in sorted array
        int pos = randomPartition(arr, l, r);

        // If position is same as k
        if (pos - l == k - 1)
            return arr[pos];
        if (pos - l > k - 1)  // If position is more, recur for left subarray
            return findKthElement(arr, l, pos - 1, k);

        // Else recur for right subarray
        return findKthElement(arr, pos + 1, r, k - pos + l - 1);

    }

    //return number of elements smaller than nums[hi]
    private int randomPartition(int[] arr, int l, int r) {
        int x = arr[r], i = l;
        for (int j = l; j <= r - 1; j++) {
            if (arr[j] <= x) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, r);
        return i;
    }
}
