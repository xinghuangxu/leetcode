package leetcode;

import helper.LinkedListFactory;
import helper.ListNode;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by k586j642 on 2/25/2016.
 */
public class OddEvenLinkedListTest extends TestCase {

    @Test
    public void test1() {
        OddEvenLinkedList oddEvenLinkedList = new OddEvenLinkedList();

        ListNode list = LinkedListFactory.createListFromString("1->2->3->4->5");
        ListNode actual = oddEvenLinkedList.oddEvenList(list);
        ListNode expected = LinkedListFactory.createListFromString("1->3->5->2->4");

        assertTrue(LinkedListFactory.isEqual(actual,expected));
    }

    @Test
    public void test2() {
        OddEvenLinkedList oddEvenLinkedList = new OddEvenLinkedList();

        ListNode actual = oddEvenLinkedList.oddEvenList(null);
        ListNode expected = null;

        assertTrue(LinkedListFactory.isEqual(actual,expected));
    }

    @Test
    public void test3() {
        OddEvenLinkedList oddEvenLinkedList = new OddEvenLinkedList();

        ListNode list = LinkedListFactory.createListFromString("1->2->3->4->5->6->7->8");
        ListNode actual = oddEvenLinkedList.oddEvenList(list);
        ListNode expected = LinkedListFactory.createListFromString("1->3->5->7->2->4->6->8");

        assertTrue(LinkedListFactory.isEqual(actual,expected));
    }

}