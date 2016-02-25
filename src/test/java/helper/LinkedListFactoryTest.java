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
}