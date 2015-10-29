package leetcode;

import helper.ListNode;

/**
 * Created by Xinghuang Leon Xu on 10/29/2015.
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        ListNode pre=head,tmp=head.next;
        while (tmp != null) {
            if(tmp.val==val){
                pre.next=tmp.next;
                tmp = pre.next;
            }else{
                pre = tmp;
                tmp = pre.next;
            }
        }
        if(head.val==val){
            return head.next;
        }
        return head;
    }
}
