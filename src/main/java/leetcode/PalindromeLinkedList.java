package leetcode;

import helper.ListNode;

import java.util.Stack;

/**
 * Created by Xinghuang Leon Xu on 9/2/2015.
 */
public class PalindromeLinkedList {

    /**
     * Method 2 reverse half of the list
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode tmp = head;
        int count = 0;
        while (tmp != null) {
            count++;
            tmp = tmp.next;
        }
        int half = count / 2;
        ListNode mid = head.next;
        ListNode beforeMid = head;
        int halfCount = half;
        while (halfCount > 1) {
            mid = mid.next;
            beforeMid = beforeMid.next;
            halfCount--;
        }
        ListNode reversedHalf = reserveList(mid);
        ListNode leftHalf = head;
        ListNode rightHalf = reversedHalf;
        while (rightHalf != null) {
            if (rightHalf.val != leftHalf.val) {
                return false;
            }
            leftHalf = leftHalf.next;
            rightHalf = rightHalf.next;
        }
        return true;
    }

    private ListNode reserveList(ListNode root) {
        ListNode prev = null;
        ListNode cur = root;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }

    /**
     * Method one uses a stack.
     *
     * @param head
     * @return
     */
    public boolean isPalindromeStack(ListNode head) {
        Stack<Integer> integerStack = new Stack();
        ListNode tmp = head;
        while (tmp != null) {
            integerStack.add(tmp.val);
            tmp = tmp.next;
        }
        tmp = head;
        while (tmp != null) {
            if (tmp.val != integerStack.pop()) {
                return false;
            }
            tmp = tmp.next;
        }
        return true;
    }
}
