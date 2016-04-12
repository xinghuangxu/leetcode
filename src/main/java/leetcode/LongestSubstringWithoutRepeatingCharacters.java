package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by k586j642 on 3/25/2016.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int[] count = new int[256];
        int longestSubString = 0;
        Deque<Integer> deque = new ArrayDeque<Integer>();
        for (int i = 0; i < s.length(); i++) {
            deque.addLast(i);
            count[s.charAt(i)]++;
            while (count[s.charAt(i)] > 1) {
                count[s.charAt(deque.getFirst())]--;
                deque.removeFirst();
            }
            int length = deque.getLast() - deque.getFirst() + 1;
            if (length > longestSubString) {
                longestSubString = length;
            }
        }
        return longestSubString;
    }
}
