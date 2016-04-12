package leetcode;

import java.util.Stack;

/**
 * Created by k586j642 on 3/24/2016.
 */
public class LargestRectangleInHistogram {
    /*
    http://www.geeksforgeeks.org/largest-rectangle-under-histogram/

    For every bar ‘x’, we calculate the area with ‘x’ as the smallest bar in the rectangle.
    If we calculate such area for every bar ‘x’ and find the maximum of all areas, our task is done.
    How to calculate area with ‘x’ as smallest bar?
    We need to know index of the first smaller (smaller than ‘x’) bar on left of ‘x’ and index of first smaller bar on right of ‘x’.
    Let us call these indexes as ‘left index’ and ‘right index’ respectively.

    We traverse all bars from left to right, maintain a stack of bars. Every bar is pushed to stack once. A bar is popped from stack when a bar of smaller height is seen.
    When a bar is popped, we calculate the area with the popped bar as smallest bar.
    How do we get left and right indexes of the popped bar – the current index tells us the ‘right index’ and index of previous item in stack is the ‘left index’.
    Following is the complete algorithm.
     */
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int i = 0;
        Stack<Integer> stack = new Stack();
        int maxArea = 0;
        while (i < n) {
            if (stack.isEmpty() || heights[stack.peek()] < heights[i]) {
                stack.push(i++);
            } else {
                int smallIndex = stack.pop();
                int smallHeight = heights[smallIndex];

                int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
                int area = width * smallHeight;
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        //i now is equal to n
        //calculate the rest
        while(!stack.isEmpty()){
            int smallIndex = stack.pop();
            int smallHeight = heights[smallIndex];
            int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
            int area = width * smallHeight;
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }
}
