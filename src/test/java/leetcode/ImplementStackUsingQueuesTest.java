package leetcode;

import helper.MyStack;
import helper.Trie;
import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by xinghuangxu on 9/10/15.
 */
public class ImplementStackUsingQueuesTest extends TestCase {

    @Test
    public void test1() {
        MyStack myStack = new MyStack();
        myStack.push(10);
        assertEquals(10, myStack.top());
        assertEquals(false, myStack.empty());
        myStack.pop();
        assertEquals(true, myStack.empty());
    }

    @Test
    public void test2() {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        assertEquals(2, myStack.top());
        assertEquals(2, myStack.top());
    }

}