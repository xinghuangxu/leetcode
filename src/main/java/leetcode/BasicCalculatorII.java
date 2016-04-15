package leetcode;

import java.util.*;

/**
 * Created by Xinghuang Leon Xu on 9/1/2015.
 */
public class BasicCalculatorII {

    public int calculate(String s) {
        List<Integer> tokens = tokenize(s);
        int i=0;
        while(i<tokens.size()){
            if(tokens.get(i)=='*'){
                int firstNumber = tokens.remove(i-1);
                tokens.remove(i-1);
                int secondNumber = tokens.remove(i-1);
                int result = firstNumber*secondNumber;
                tokens.add(i-1,result);
                i=i-1;
            }else if(tokens.get(i)=='/'){
                int firstNumber = tokens.remove(i-1);
                tokens.remove(i-1);
                int secondNumber = tokens.remove(i-1);
                int result = firstNumber/secondNumber;
                tokens.add(i-1,result);
                i=i-1;
            }else{
                i++;
            }
        }

        i=0;
        while(i<tokens.size()){
            if(tokens.get(i)=='+'){
                int firstNumber = tokens.remove(i-1);
                tokens.remove(i-1);
                int secondNumber = tokens.remove(i-1);
                int result = firstNumber+secondNumber;
                tokens.add(i-1,result);
                i=i-1;
            }else if(tokens.get(i)=='-'){
                int firstNumber = tokens.remove(i-1);
                tokens.remove(i-1);
                int secondNumber = tokens.remove(i-1);
                int result = firstNumber-secondNumber;
                tokens.add(i-1,result);
                i=i-1;
            }else{
                i++;
            }
        }

        return tokens.get(0);
    }

    private List<Integer> tokenize(String s) {
        List<Integer> tokens = new LinkedList();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*' || s.charAt(i) == '/' || s.charAt(i) == '+'|| s.charAt(i) == '-') {
                tokens.add((int)s.charAt(i));
            } else if (isCharANum(s.charAt(i))) {
                int num = s.charAt(i)-'0';
                int p = i + 1;
                while (p < s.length() && isCharANum(s.charAt(p))) {
                    num= num*10 + s.charAt(p)-'0';
                    p++;
                }
                tokens.add(num);
                i=p-1;
            }
        }
        return tokens;
    }

    boolean isCharANum(char c) {
        return '0' <= c && c <= '9';
    }

    /*
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

    */
}
