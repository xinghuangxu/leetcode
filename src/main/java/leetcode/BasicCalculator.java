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
            Stack<State> stack = new Stack<State>();
            stack.add(new A());
            while (!(stack.peek() instanceof Accept)) {
                stack.peek().process(stack, tokens);
            }
            return Integer.parseInt(stack.peek().val);
        }
    }

    class A extends State {

        @Override
        void process(Stack<State> stack, Queue<String> tokens) {
            String nextToken = tokens.poll();
            State state = getNextState(nextToken);
            state.val = nextToken;
            stack.push(state);
        }

        @Override
        State getNextState(String token) {
            if (token.equals("(")) {
                return (new D());
            } else { // nextToken is EN
                return (new B());
            }
        }
    }

    class B extends State {

        @Override
        void process(Stack<State> stack, Queue<String> tokens) {
            if (tokens.isEmpty()) {
                String result = stack.pop().val;
                State accept = new Accept();
                accept.val = result;
                stack.push(accept);
            } else {
                String nextToken = tokens.poll();
                State state = getNextState(nextToken);
                state.val = nextToken;
                stack.push(state);
                state.process(stack, tokens);
            }
        }

        @Override
        State getNextState(String token) {
            if (token.equals("+") || token.equals("-")) {
                return (new C());
            }
            return new G();
        }
    }

    class C extends State {

        @Override
        void process(Stack<State> stack, Queue<String> tokens) {
            String nextToken = tokens.poll();
            State state = getNextState(nextToken);
            state.val = nextToken;
            stack.push(state);
        }

        @Override
        State getNextState(String token) {
            if (token.equals("(")) {
                return (new D());
            } else { // nextToken is EN
                return (new E());
            }
        }
    }

    class D extends State {

        @Override
        void process(Stack<State> stack, Queue<String> tokens) {
            String nextToken = tokens.poll();
            State state = getNextState(nextToken);
            state.val = nextToken;
            stack.push(state);
        }

        @Override
        State getNextState(String token) {
            if (token.equals("(")) {
                return (new D());
            } else { // nextToken is EN
                return (new F());
            }
        }
    }

    class E extends State {

        @Override
        void process(Stack<State> stack, Queue<String> tokens) {
            int secondNum = Integer.parseInt(stack.pop().val);
            String operator = stack.pop().val;
            int firstNum = Integer.parseInt(stack.pop().val);
            int sum = 0;
            if (operator.equals("+")) {
                sum = firstNum + secondNum;
            } else {
                sum = firstNum - secondNum;
            }
            State preState = stack.peek();
            State state = preState.getNextState(sum + "");
            state.val = sum + "";
            stack.push(state);
        }

        @Override
        State getNextState(String token) {
            return null;
        }
    }

    class F extends State {

        @Override
        void process(Stack<State> stack, Queue<String> tokens) {
            String nextToken = tokens.poll();
            State state = getNextState(nextToken);
            state.val = nextToken;
            stack.push(state);
        }

        @Override
        State getNextState(String token) {
            if (token.equals(")")) {
                return (new H());
            } else if (token.equals("+") || token.equals("-")) { // nextToken is EN
                return (new C());
            } else {
                return new G();
            }
        }
    }

    class G extends State {

        @Override
        void process(Stack<State> stack, Queue<String> tokens) {

        }

        @Override
        State getNextState(String token) {
            return null;
        }

    }

    class H extends State {
        @Override
        void process(Stack<State> stack, Queue<String> tokens) {
            stack.pop();
            State oldState = stack.pop();
            stack.pop();
            State prevState = stack.peek();
            State newState = prevState.getNextState(oldState.val);
            newState.val = oldState.val;
            stack.push(newState);
        }

        @Override
        State getNextState(String token) {
            return null;
        }
    }

    class Accept extends State {

        @Override
        void process(Stack<State> stack, Queue<String> tokens) {

        }

        @Override
        State getNextState(String token) {
            return null;
        }
    }

    // 6. Create a state base class that makes the concrete states interchangeable
    abstract class State {
        String val;

        abstract void process(Stack<State> stack, Queue<String> tokens);

        abstract State getNextState(String token);
    }


    private Queue<String> tokenize(String s) {
        Queue<String> tokens = new ArrayDeque();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')' || s.charAt(i) == '+' || s.charAt(i) == '-') {
                tokens.add(s.charAt(i) + "");
            } else if (isCharANum(s.charAt(i))) {
                int p = i + 1;
                while (p < s.length() && isCharANum(s.charAt(p))) {
                    p++;
                }
                tokens.add(s.substring(i, p));
                i = p - 1;
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
