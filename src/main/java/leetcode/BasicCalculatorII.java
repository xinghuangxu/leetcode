package leetcode;

import java.util.Stack;

/**
 * Created by Xinghuang Leon Xu on 9/1/2015.
 */
public class BasicCalculatorII {


    int location;

    public int calculate(String s) {
        location = 0;
        String nextToken;
        Stack<String> stack = new Stack();
        while ((nextToken = retrieveNextToken(s)) != null) {
            if (nextToken.equals("*")) {
                int left = Integer.valueOf(stack.pop());
                int right = Integer.valueOf(retrieveNextToken(s));
                stack.add(left * right + "");
            } else if (nextToken.equals("/")) {
                int left = Integer.valueOf(stack.pop());
                int right = Integer.valueOf(retrieveNextToken(s));
                stack.add(left / right + "");
            } else {
                stack.add(nextToken);
            }
        }

        while (stack.size() > 1) {
            calculateStack(stack);
        }

        return Integer.valueOf(stack.get(0));
    }

    private void calculateStack(Stack<String> stack) {
        int result = 0;
        while (!stack.isEmpty()) {
            String val = stack.pop();
            int num = Integer.valueOf(val);
            val = stack.isEmpty() ? null : stack.pop();
            if (val == null || val.equals("+")) {
                result += num;
            } else {
                result -= num;
            }
        }
        stack.push(result + "");
    }

    private String retrieveNextToken(String s) {
        while (location < s.length() && s.charAt(location) == ' ') location++;
        if (location == s.length()) return null; //end of String
        char c = s.charAt(location);
        if (c == '*' || c == '/' || c == '+' || c == '-') {
            location++;
            return c + "";
        }
        String num = c + "";
        while (location + 1 < s.length() && s.charAt(location + 1) >= '0' && s.charAt(location + 1) <= '9') {
            location++;
            c = s.charAt(location);
            num += c;
        }
        location++;
        return num;
    }
}
