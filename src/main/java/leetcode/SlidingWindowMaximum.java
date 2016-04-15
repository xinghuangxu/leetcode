package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * Created by k586j642 on 3/24/2016.
 */
public class SlidingWindowMaximum {

    //java deque solution
    //make sure that the front of the deque always has the biggest number seem so far
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0 || nums.length == 0) return new int[]{};
        int[] maxSlidingWindows = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque();
        for (int i = 0; i < nums.length; i++) {
            //add new elements to the end of deque, remove elements from the end of it's smaller than the new element
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
            //remove elements outside the window
            while (deque.getFirst() <= i - k) {
                deque.removeFirst();
            }
            if (i >= k - 1) {
                maxSlidingWindows[i - k + 1] = nums[deque.getFirst()];
            }
        }
        return maxSlidingWindows;
    }

    //The following is a nlogk solution

//    class Element implements Comparable<Element> {
//        int index;
//        int inDegree;
//
//        Element(int index, int inDegree) {
//            this.index = index;
//            this.inDegree = inDegree;
//        }
//
//        public int compareTo(Element o) {
//            if (inDegree > o.inDegree) return -1;
//            if (inDegree == o.inDegree) return 0;
//            return 1;
//        }
//    }
//
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        if (k == 0 || nums.length == 0) return new int[]{};
//        Element[] elements = new Element[nums.length];
//        int[] result = new int[nums.length - k + 1];
//        PriorityQueue<Element> queue = new PriorityQueue<Element>();
//        for (int i = 0; i < nums.length; i++) {
//            elements[i] = new Element(i, nums[i]);
//        }
//        for (int i = 0; i < k; i++) {
//            queue.add(elements[i]);
//        }
//        result[0] = queue.peek().inDegree;
//        for (int i = 0; i < nums.length - k; i++) {
//            queue.remove(result[i]);
//            queue.add(elements[i + k]);
//            result[i + 1] = queue.peek().inDegree;
//        }
//        return result;
//    }

}
