package leetcode;

import java.util.Iterator;

/**
 * Created by xinghuangxu on 10/29/15.
 */
public class PeekingIterator implements Iterator<Integer> {

    Iterator<Integer> iterator;
    Integer next = null;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (next == null && iterator.hasNext()) {
            next = iterator.next();
        }
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    public Integer next() {
        peek();
        Integer b = next;
        next = null;
        return b;
    }

    public boolean hasNext() {
        peek();
        return next != null;
    }
}
