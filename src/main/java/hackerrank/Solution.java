package hackerrank;

/**
 * Created by Xinghuang Leon Xu on 10/10/2015.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt((br.readLine().split(" "))[2]);
        Solution solution = new Solution(br.readLine(),br.readLine());
        solution.findMinimumDecision(k);
    }

    Solution(String A, String B) {
        this.A = A;
        this.B = B;
    }

    public String findMinimumDecision(int k) {
        MinimumDecision(new State("", ""));
        List<State> sortedList = new ArrayList(winningPositions);
        Collections.sort(sortedList);
        System.out.println(sortedList.get(k - 1).aprime);
        System.out.println(sortedList.get(k - 1).bprime);
        return sortedList.get(k-1).toString();
    }

    String A;
    String B;
    Set<State> winningPositions = new HashSet();

    class State implements Comparable<State> {
        String aprime;
        String bprime;

        State(String aprime, String bprime) {
            this.aprime = aprime;
            this.bprime = bprime;
        }

        public int compareTo(State o) {
            int rel = aprime.compareTo(o.aprime);
            return rel != 0 ? rel : bprime.compareTo(o.bprime);
        }

        @Override
        public boolean equals(Object other) {
            if (other == this)
                return true;
            if (!(other instanceof State))
                return false;
            return ((State) other).aprime.equals(this.aprime) && ((State) other).bprime.equals(this.bprime);
        }

        @Override
        public int hashCode() {
            return (aprime + ":" + bprime).hashCode();
        }

        @Override
        public String toString() {
            return aprime + "," + bprime;
        }
    }

    class Action {
        int option; //Could be 0(A) or 1(B)
        char c;  //character to append

        Action(int option, char c) {
            this.option = option;
            this.c = c;
        }
    }

    public Action MinimumDecision(State state) {
        List<Action> actions = getActions(state);
        int max = 0;
        int currentValue = MinValue(getResult(state, actions.get(0)));
        for (int i = 1; i < actions.size(); i++) {
            int tmp = MinValue(getResult(state, actions.get(i)));
            if (tmp > currentValue) {
                max = i;
                currentValue = tmp;
            }
        }
        return actions.get(max);
    }

    private State getResult(State state, Action action) {
        if (action.option == 0) {
            return new State(state.aprime + action.c, state.bprime);
        } else {
            return new State(state.aprime, state.bprime + action.c);
        }
    }

    public int MaxValue(State state) {
        List<Action> actions = getActions(state);
        if (actions.size() == 0) return -1;
        int result = -1;
        for (int i = 0; i < actions.size(); i++) {
            if (MinValue(getResult(state, actions.get(i))) == 1) {
                winningPositions.add(state);
                result = 1;
            }
        }
        return result;
    }

    public int MinValue(State state) {
        List<Action> actions = getActions(state);
        if (actions.size() == 0) return 1;
        int result = 1;
        for (int i = 0; i < actions.size(); i++) {
            if (MaxValue(getResult(state, actions.get(i))) == -1) {
                winningPositions.add(state);
                result = -1;
            }
        }
        return result;
    }

    private List<Action> getActions(State state) {
        List<Action> actions = new ArrayList();
        //consider A
        boolean[] visited = new boolean[26];
        int aLength = state.aprime.length();
        int index = A.indexOf(state.aprime);
        while (index >= 0 && index + aLength < A.length()) {
            if (!visited[A.charAt(index + aLength) - 'a']) {
                visited[A.charAt(index + aLength) - 'a'] = true;
                actions.add(new Action(0, A.charAt(index + aLength)));
            }
            index = A.indexOf(state.aprime, index + aLength + 1);
        }
        //consider B
        visited = new boolean[26];
        int bLength = state.bprime.length();
        index = B.indexOf(state.bprime);
        while (index >= 0 && index + bLength < B.length()) {
            if (!visited[B.charAt(index + bLength) - 'a']) {
                visited[B.charAt(index + bLength) - 'a'] = true;
                actions.add(new Action(1, B.charAt(index + bLength)));
            }
            index = B.indexOf(state.bprime, index + bLength + 1);
        }
        return actions;
    }
}