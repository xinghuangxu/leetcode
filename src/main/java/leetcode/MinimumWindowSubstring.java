package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by k586j642 on 3/25/2016.
 */
public class MinimumWindowSubstring {

    //solution without deque
    public String minWindow(String s, String t) {
        int minLeft = 0, minRight = Integer.MAX_VALUE;
        int[] count = new int[256];
        int totalCount = 0;
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i)]++;
            totalCount++;
        }
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)] > 0) {
                totalCount--;
            }
            count[s.charAt(i)]--;
            right = i;
            while (left != right && count[s.charAt(left)] < 0) {
                count[s.charAt(left)]++;
                left++;
            }
            if (totalCount == 0 && right - left < minRight - minLeft) {
                minRight = right;
                minLeft = left;
            }
        }
        if (minRight == Integer.MAX_VALUE) return "";
        return s.substring(minLeft, minRight + 1);
    }

    //solution with Deque
    /*
    public String minWindow(String s, String t) {
        int minLeft = 0, minRight = Integer.MAX_VALUE;
        int[] count = new int[256];
        int totalCount = 0;
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i)]++;
            totalCount++;
        }
        Deque<Integer> deque = new ArrayDeque<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)] > 0) {
                totalCount--;
            }
            count[s.charAt(i)]--;
            deque.addLast(i);
            while (!deque.isEmpty() && count[s.charAt(deque.getFirst())] < 0) {
                count[s.charAt(deque.getFirst())]++;
                deque.removeFirst();
            }
            if (totalCount == 0 && deque.getLast() - deque.getFirst() < minRight - minLeft) {
                minRight = deque.getLast();
                minLeft = deque.getFirst();
            }
        }
        if (minRight == Integer.MAX_VALUE) return "";
        return s.substring(minLeft, minRight + 1);
    }
    */
}
