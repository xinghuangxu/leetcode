package leetcode;

import helper.ListNode;
import junit.framework.TestCase;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

/**
 * Created by Xinghuang Leon Xu on 9/3/2015.
 */
public class DeleteNodeInALinkedListTest extends TestCase {
    @Test
    public void test() {
        DeleteNodeInALinkedList deleteNodeInALinkedList = new DeleteNodeInALinkedList();
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        head.next = node2;
        node2.next = node3;
        deleteNodeInALinkedList.deleteNode(node2);
        assertEquals(node3.val, head.next.val);
        assertEquals(null, head.next.next);
    }
}