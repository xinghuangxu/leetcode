package helper;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by xinghuangxu on 2/25/16.
 */
public class LinkedListFactoryTest extends TestCase {

    @Test
    public void test1() {
        ListNode list = LinkedListFactory.createListFromString("1->2->3->4->5");
        int[] linkedListValues = {1,2,3,4,5};

        for(int i = 0; i<linkedListValues.length; i++){
            assertEquals(list.val,linkedListValues[i]);
            list= list.next;
        }
    }

    @Test
    public void test2() {
        ListNode list = LinkedListFactory.createListFromString("1->2->3->4->5");
        ListNode list2 = LinkedListFactory.createListFromString("1->2->3->4->5");
        ListNode list3 = LinkedListFactory.createListFromString("2->3->4->5");
        ListNode list4 = LinkedListFactory.createListFromString("1->2->3->4->5->6");
        assertTrue(LinkedListFactory.isEqual(list, list2));
        assertFalse(LinkedListFactory.isEqual(list, list3));
        assertFalse(LinkedListFactory.isEqual(list,list4));
    }

    @Test
    public void test3() {
        ListNode list = LinkedListFactory.createListFromString("1->2->3->4->5");
        ListNode list2 = LinkedListFactory.createListFromString("1->2->3->4->5");
        ListNode list3 = LinkedListFactory.createListFromString("2->3->4->5");
        ListNode list4 = LinkedListFactory.createListFromString("1->2->3->4->5->6");
        assertTrue(LinkedListFactory.isEqual(list, list2));
        assertFalse(LinkedListFactory.isEqual(list, list3));
        assertFalse(LinkedListFactory.isEqual(list,list4));
    }
}