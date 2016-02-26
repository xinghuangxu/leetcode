package leetcode;

import helper.ListNode;

/**
 * Created by xinghuangxu on 2/25/16.
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) return head; //list has only one element

        ListNode evenStart=new ListNode(0),evenEnd, oddStart=new ListNode(0), oddEnd;
        oddEnd=oddStart;
        evenEnd = evenStart;

        boolean odd=true;
        ListNode cur = head, tmp;
        while(cur!=null){
            tmp = cur;
            cur = cur.next;
            tmp.next = null;
            if(odd){
                oddEnd.next = tmp;
                oddEnd = tmp;
            }else{
                evenEnd.next = tmp;
                evenEnd = tmp;
            }
            odd=!odd;
        }
        evenEnd.next = null;
        oddEnd.next = evenStart.next;
        return oddStart.next;
    }
}
