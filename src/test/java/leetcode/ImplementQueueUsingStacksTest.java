package leetcode;

import helper.MyQueue;
import helper.Trie;
import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Xinghuang Leon Xu on 9/1/2015.
 */
public class ImplementQueueUsingStacksTest extends TestCase {
    @Test
    public void test1() {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        assertEquals(1, myQueue.peek());
        myQueue.pop();
        assertEquals(2, myQueue.peek());
        myQueue.pop();
        assertEquals(3, myQueue.peek());
        myQueue.pop();
        assertEquals(true, myQueue.empty());
    }
}