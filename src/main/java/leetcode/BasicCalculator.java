package leetcode;

import java.util.*;
import java.util.Stack;

/**
 * Created by Xinghuang Leon Xu on 8/31/2015.
 */
public class BasicCalculator {


    public int calculate(String s) {
        Queue<String> tokens = tokenize(s);
        FSM fsm = new FSM();
        return fsm.process(tokens);
    }

    class FSM {
        public State root = new A();

        public int process(Queue<String> tokens) {
            Stack<String> stack = new Stack<String>();
            stack.add("$");
            int value = 0;
            while (!tokens.isEmpty()) {
                State current = root.locate(stack, 0);
                value = current.process(stack, tokens);
            }
            return value;
        }
    }

    class A extends State {

        @Override
        int process(Stack<String> stack, Queue<String> tokens) {
            String nextToken = tokens.poll();
            State state = getNextState(nextToken);
            stack.push(nextToken);
            return state.process(stack, tokens);
        }

        @Override
        State locate(Stack<String> stack, int pos) {
            if (pos == stack.size() - 1) {
                return this;
            }
            String nextToken = stack.get(pos + 1);
            return getNextState(nextToken);
        }

        @Override
        State getNextState(String token) {
            if (token.equals("(")) {
                return (new B());
            } else { // nextToken is E
                return (new D());
            }
        }
    }

    class B extends State {

        @Override
        int process(Stack<String> stack, Queue<String> tokens) {
            if (tokens.isEmpty()) {
                return Integer.parseInt(stack.peek());
            } else {
                String nextToken = tokens.poll();
                stack.push(nextToken);
                return getNextState(nextToken).process(stack, tokens);
            }
        }

        @Override
        State locate(Stack<String> stack, int pos) {
            if (pos == stack.size() - 1) {
                return this;
            }
            String nextToken = stack.get(pos + 1);
            return getNextState(nextToken);
        }

        @Override
        State getNextState(String token) {
            if (token.equals("+")) {
                return (new C());
            }
            return new G();
        }
    }

    class C extends State {

        @Override
        int process(Stack<String> stack, Queue<String> tokens) {
            String nextToken = tokens.poll();
            State state = getNextState(nextToken);
            stack.push(nextToken);
            return state.process(stack, tokens);
        }

        @Override
        State locate(Stack<String> stack, int pos) {
            if (pos == stack.size() - 1) {
                return this;
            }
            String nextToken = stack.get(pos + 1);
            return getNextState(nextToken);
        }

        @Override
        State getNextState(String token) {
            if (token.equals("(")) {
                return (new D());
            } else { // nextToken is E
                return (new E());
            }
        }
    }

    class D extends State {

        @Override
        int process(Stack<String> stack, Queue<String> tokens) {
            String nextToken = tokens.poll();
            State state = getNextState(nextToken);
            stack.push(nextToken);
            return state.process(stack, tokens);
        }

        @Override
        State locate(Stack<String> stack, int pos) {
            if (pos == stack.size() - 1) {
                return this;
            }
            String nextToken = stack.get(pos + 1);
            return getNextState(nextToken);
        }

        @Override
        State getNextState(String token) {
            if (token.equals("(")) {
                return (new D());
            } else { // nextToken is E
                return (new F());
            }
        }
    }

    class E extends State {

        @Override
        int process(Stack<String> stack, Queue<String> tokens) {
            return 0;
        }

        @Override
        State locate(Stack<String> stack, int pos) {
            if (pos == stack.size() - 1) {
                return this;
            }
            String nextToken = stack.get(pos + 1);
            return getNextState(nextToken);
        }

        @Override
        State getNextState(String token) {
            if (token.equals("(")) {
                return (new D());
            } else { // nextToken is E
                return (new F());
            }
        }
    }

    class F extends State {

        @Override
        int process(Stack<String> stack, Queue<String> tokens) {
            return 0;
        }

        @Override
        State locate(Stack<String> stack, int pos) {
            return null;
        }

        @Override
        State getNextState(String token) {
            return null;
        }
    }

    class G extends State {

        @Override
        int process(Stack<String> stack, Queue<String> tokens) {
            return 0;
        }

        @Override
        State locate(Stack<String> stack, int pos) {
            return new G();
        }

        @Override
        State getNextState(String token) {
            return null;
        }
    }

    // 6. Create a state base class that makes the concrete states interchangeable
    abstract class State {
        abstract int process(Stack<String> stack, Queue<String> tokens);

        abstract State locate(Stack<String> stack, int pos);

        abstract State getNextState(String token);
    }


    private Queue<String> tokenize(String s) {
        Queue<String> tokens = new ArrayDeque();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')' || s.charAt(i) == '+') {
                tokens.add(s.charAt(i) + "");
            } else if (isCharANum(s.charAt(i))) {
                int p = i + 1;
                while (p < s.length() && isCharANum(s.charAt(i))) {
                    p++;
                }
                if (isCharANum(s.charAt(p))) tokens.add(s.substring(i, p + 1));
                else tokens.add(s.substring(i, p));
            }
        }
        return tokens;
    }

    boolean isCharANum(char c) {
        return '0' <= c && c <= '9';
    }


//    int location;
//
//    public int calculate(String s) {
//        location = 0;
//        String nextToken;
//        Stack<String> stack = new Stack();
//        while ((nextToken = retrieveNextToken(s)) != null) {
//            if (nextToken.equals(")")) {
//                calculateStack(stack);
//            } else {
//                stack.add(nextToken);
//            }
//        }
//        while (stack.size() > 1) {
//            calculateStack(stack);
//        }
//        return Integer.valueOf(stack.get(0));
//    }
//
//    private void calculateStack(Stack<String> stack) {
//        int result = 0;
//        while (!stack.isEmpty()) {
//            String val = stack.pop();
//            if (val.equals("(")) {
//                stack.push(result + "");
//                return;
//            } else {
//                int num = Integer.valueOf(val);
//                val = stack.isEmpty() ? "(" : stack.pop();
//                if (val == null || val.equals("(") || val.equals("+")) {
//                    result += num;
//                    if(val.equals("(")){
//                        stack.push(result + "");
//                        return;
//                    }
//                } else {
//                    result -= num;
//                }
//            }
//        }
//        stack.push(result + "");
//    }
//
//    private String retrieveNextToken(String s) {
//        while (location < s.length() && s.charAt(location) == ' ') location++;
//        if (location == s.length()) return null; //end of String
//        char c = s.charAt(location);
//        if (c == '(' || c == ')' || c == '+' || c == '-') {
//            location++;
//            return c + "";
//        }
//        String num = c + "";
//        while (location + 1 < s.length() && s.charAt(location + 1) >= '0' && s.charAt(location + 1) <= '9') {
//            location++;
//            c = s.charAt(location);
//            num += c;
//        }
//        location++;
//        return num;
//    }
}
