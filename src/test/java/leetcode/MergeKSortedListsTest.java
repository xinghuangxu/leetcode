package leetcode;

import helper.ListNode;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by k586j642 on 3/29/2016.
 */
public class MergeKSortedListsTest extends TestCase {
    @Test
    public void test1() {
        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        ListNode list1 = new ListNode(2);
        list1.next = new ListNode(5);
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(9);
        ListNode[] lists = new ListNode[]{list1, list2};
        ListNode actual = mergeKSortedLists.mergeKLists(lists);

    }
}