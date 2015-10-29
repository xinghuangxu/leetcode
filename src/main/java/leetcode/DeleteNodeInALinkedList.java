package leetcode;

import helper.ListNode;

/**
 * Created by Xinghuang Leon Xu on 9/3/2015.
 */
public class DeleteNodeInALinkedList {

    public void deleteNode(ListNode node) {
        ListNode tmp = node;
        ListNode prev = null;
        while (tmp.next != null) {
            tmp.val = tmp.next.val;
            prev = tmp;
            tmp = tmp.next;
        }
        if (prev != null) {
            prev.next = null;
        }
    }
}
