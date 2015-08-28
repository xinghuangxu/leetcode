package leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by leonx on 8/20/2015.
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue;
        if(k>nums.length/2){
            priorityQueue = new PriorityQueue<Integer>(nums.length);
            k = nums.length - k;
        }else{
            priorityQueue = new PriorityQueue<Integer>(nums.length, Collections.reverseOrder());
        }
        for(int i=0;i<nums.length;i++){
            priorityQueue.add(nums[i]);
        }
        int result =0 ;
        for(int i=0;i<k;i++){
            result = priorityQueue.poll();
        }
        return result;
    }

}
