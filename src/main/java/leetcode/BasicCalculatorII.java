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

        Queue<Token> tokens = tokenize(s);
        FSM fsm = new FSM();
        return fsm.process(tokens);
    }

    class Token {
        int val;

        Token(int val){
            this.val = val;
        }

        public int getValue() {
            return val;
        }
    }

    class S extends N {

        S(int val) {
            super(val);
        }
    }

    class T extends N {

        T(int val) {
            super(val);
        }
    }

    class N extends Token {
        N(int val) {
            super(val);
        }
    }

    class PlusMinus extends Token {

        PlusMinus(int val) {
            super(val);
        }
    }

    class StarDiv extends Token {

        StarDiv(int val) {
            super(val);
        }
    }

    class FSM {
        public State root = new A();

        public int process(Queue<Token> tokens) {
            Stack<State> stack = new Stack<State>();
            stack.add(new A());
            while (!(stack.peek() instanceof Accept) && !(stack.peek() instanceof Fail)) {
                stack.peek().process(stack, tokens);
            }
            return stack.peek().token.getValue();
        }
    }

    class A extends State {

        @Override
        void process(Stack<State> stack, Queue<Token> tokens) {
            Token nextToken = tokens.poll();
            State state = getNextState(nextToken);
            state.token = nextToken;
            stack.push(state);
        }

        @Override
        State getNextState(Token token) {
            if (token instanceof S) {
                return (new B());
            } else if (token instanceof T) { // nextToken is EN
                return (new D());
            } else if (token instanceof N) {
                return new F();
            } else {
                return new Fail();
            }
        }
    }

    class B extends State {

        @Override
        void process(Stack<State> stack, Queue<Token> tokens) {
            if (tokens.isEmpty()) {
                Token result = stack.pop().token;
                State accept = new Accept();
                accept.token = result;
                stack.push(accept);
            } else {
                Token nextToken = tokens.poll();
                State state = getNextState(nextToken);
                state.token = nextToken;
                stack.push(state);
                state.process(stack, tokens);
            }
        }

        @Override
        State getNextState(Token token) {
            return new Fail();
        }
    }


    class C extends State {

        @Override
        void process(Stack<State> stack, Queue<Token> tokens) {
            int second = stack.pop().token.getValue();
            char operator = (char)stack.pop().token.getValue();
            int first = stack.pop().token.getValue();
            int sum = operate(first, second, operator);
            Token newToken = new S(sum);
            State prevState = stack.peek();
            State newState = prevState.getNextState(newToken);
            newState.token = newToken;
            stack.push(newState);
        }


        @Override
        State getNextState(Token token) {
            return new Fail();
        }
    }

    class D extends State {

        @Override
        void process(Stack<State> stack, Queue<Token> tokens) {
            Token nextToken = tokens.peek();
            //there is a shift reduce conflict here
            if(nextToken instanceof PlusMinus){
                tokens.poll();
                State state = getNextState(nextToken);
                state.token = nextToken;
                stack.push(state);
            }else{
                State state = stack.pop();
                if(state.token instanceof T){
                    Token newToken = new S(state.token.getValue());
                    State prevState = stack.peek();
                    State newState = prevState.getNextState(newToken);
                    newState.token = newToken;
                    stack.push(newState);
                }else{
                    stack.push(new Fail());
                }
            }
        }

        @Override
        State getNextState(Token token) {
            if (token instanceof PlusMinus) {
                return (new E());
            } else { // nextToken is EN
                return new Fail();
            }
        }
    }

    class E extends State {

        @Override
        void process(Stack<State> stack, Queue<Token> tokens) {
            Token nextToken = tokens.poll();
            State state = getNextState(nextToken);
            state.token = nextToken;
            stack.push(state);
        }

        @Override
        State getNextState(Token token) {
            if (token instanceof T) {
                return (new C());
            } else if (token instanceof N) {
                return new F();
            } else { // nextToken is EN
                return new Fail();
            }
        }
    }

    class F extends State {

        @Override
        void process(Stack<State> stack, Queue<Token> tokens) {
            Token nextToken = tokens.peek();
            //there is a shift reduce conflict here
            if(nextToken instanceof StarDiv){
                tokens.poll();
                State state = getNextState(nextToken);
                state.token = nextToken;
                stack.push(state);
            }else{
                State state = stack.pop();
                if(state.token instanceof N){
                    Token newToken = new T(state.token.getValue());
                    State prevState = stack.peek();
                    State newState = prevState.getNextState(newToken);
                    newState.token = newToken;
                    stack.push(newState);
                }else{
                    stack.push(new Fail());
                }
            }
        }

        @Override
        State getNextState(Token token) {
            if (token instanceof StarDiv) {
                return (new G());
            } else {
                return new Fail();
            }
        }
    }

    class G extends State {

        @Override
        void process(Stack<State> stack, Queue<Token> tokens) {
            Token nextToken = tokens.poll();
            State state = getNextState(nextToken);
            state.token = nextToken;
            stack.push(state);
        }

        @Override
        State getNextState(Token token) {
            if (token instanceof N) {
                return (new H());
            } else {
                return new Fail();
            }
        }
    }

    class H extends State {
        @Override
        void process(Stack<State> stack, Queue<Token> tokens) {
            int second = stack.pop().token.getValue();
            char operator = (char)stack.pop().token.getValue();
            int first = stack.pop().token.getValue();
            int sum = operate(first, second, operator);
            Token newToken = new T(sum);
            State prevState = stack.peek();
            State newState = prevState.getNextState(newToken);
            newState.token = newToken;
            stack.push(newState);
        }

        @Override
        State getNextState(Token token) {
            return new Fail();
        }
    }

    class Accept extends State {

        @Override
        void process(Stack<State> stack, Queue<Token> tokens) {
        }

        @Override
        State getNextState(Token token) {
            return null;
        }
    }

    class Fail extends State {

        @Override
        void process(Stack<State> stack, Queue<Token> tokens) {

        }

        @Override
        State getNextState(Token token) {
            return null;
        }
    }

    // 6. Create a state base class that makes the concrete states interchangeable
    abstract class State {
        Token token;

        abstract void process(Stack<State> stack, Queue<Token> tokens);

        abstract State getNextState(Token token);

        int operate(int first, int second, char operator) {
            if (operator == '+') {
                return first + second;
            } else if (operator == '-') {
                return first - second;
            } else if (operator == '*') {
                return first * second;
            } else if (operator == '/') {
                return first / second;
            } else return 0;
        }
    }


    private Queue<Token> tokenize(String s) {
        Queue<Token> tokens = new ArrayDeque();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')' || s.charAt(i) == '+' || s.charAt(i) == '-') {
                PlusMinus operator = new PlusMinus(s.charAt(i));
                tokens.add(operator);
            } else if(s.charAt(i) == '*'||s.charAt(i) == '/'){
                StarDiv operator = new StarDiv(s.charAt(i));
                tokens.add(operator);
            }else if (isCharANum(s.charAt(i))) {
                int p = i + 1;
                while (p < s.length() && isCharANum(s.charAt(p))) {
                    p++;
                }
                tokens.add(new N(Integer.parseInt(s.substring(i, p))));
                i = p - 1;
            }
        }
        return tokens;
    }

    boolean isCharANum(char c) {
        return '0' <= c && c <= '9';
    }

/*
>>>>>>> 34880c65bdfc5cf088fb37238a469ad510e3bc6c
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
