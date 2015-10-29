package leetcode;

import helper.ListNode;

/**
 * Created by xinghuangxu on 10/27/15.
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, cur = head, tmp;
        while(cur!=null){
            tmp = cur.next;
            cur.next = prev;
            prev= cur;
            cur = tmp;
        }
        return prev;
    }
}
