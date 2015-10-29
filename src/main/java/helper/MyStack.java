package helper;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by xinghuangxu on 9/10/15.
 */
public class MyStack {

    Queue<Integer> current = new ArrayDeque();

    // Push element x onto stack.
    public void push(int x) {
        current.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (!current.isEmpty()) {
            for (int i = 0; i < current.size() - 1; i++) {
                current.add(current.peek());
                current.poll();
            }
            current.poll();
        }
    }

    // Get the top element.
    public int top() {
        for (int i = 0; i < current.size() - 1; i++) {
            current.add(current.peek());
            current.poll();
        }
        int result = current.peek();
        current.poll();
        current.add(result);
        return result;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return current.isEmpty();
    }

}
