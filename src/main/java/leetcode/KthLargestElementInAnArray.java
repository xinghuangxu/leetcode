package leetcode;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created by leonx on 8/20/2015.
 */
public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        return findKthElement(nums, 0, nums.length - 1, nums.length - k + 1);
    }

    Random random = new Random();

    private void swap(int[] nums, int n1, int n2) {
        int tmp = nums[n1];
        nums[n1] = nums[n2];
        nums[n2] = tmp;
    }

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

    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue;
        if (k > nums.length / 2) {
            priorityQueue = new PriorityQueue<Integer>(nums.length);
            k = nums.length - k + 1;
        } else {
            priorityQueue = new PriorityQueue<Integer>(nums.length, Collections.reverseOrder());
        }
        for (int i = 0; i < nums.length; i++) {
            priorityQueue.add(nums[i]);
        }
        int result = 0;
        for (int i = 0; i < k; i++) {
            result = priorityQueue.poll();
        }
        return result;
    }

}
