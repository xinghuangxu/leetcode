package helper;

import java.util.Stack;

/**
 * Created by Xinghuang Leon Xu on 9/1/2015.
 */
public class MyQueue {

    private Stack<Integer> staged = new Stack();
    private Stack<Integer> live = new Stack();

    // Push element x to the back of queue.
    public void push(int x) {
        staged.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        readFromStagedIfNeeded();
        if (!live.isEmpty()) {
            live.pop();
        }
    }

    private void readFromStagedIfNeeded() {
        if (live.size() == 0) {
            while (!staged.isEmpty()) {
                live.add(staged.pop());
            }
        }
    }

    // Get the front element.
    public int peek() {
        readFromStagedIfNeeded();
        return live.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        readFromStagedIfNeeded();
        return live.isEmpty();
    }
}
