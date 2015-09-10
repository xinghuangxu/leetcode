package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xinghuangxu on 9/10/15.
 */
public class DifferentWaysToAddParentheses {
    List<Integer> numbers = new ArrayList<Integer>();
    List<Character> operators = new ArrayList<Character>();

    public List<Integer> diffWaysToCompute(String input) {
        parseFormula(input);
        return diffWaysToComputeRecursively(0, numbers.size() - 1);
    }

    private List<Integer> diffWaysToComputeRecursively(int start, int end) {
        List<Integer> result = new ArrayList<Integer>();
        if (start == end) {
            result.add(numbers.get(start));
            return result;
        }
        for (int i = start; i < end - 1; i++) {
            List<Integer> left = diffWaysToComputeRecursively(start, i);
            List<Integer> right = diffWaysToComputeRecursively(i + 1, end);
            List<Integer> out = calculate(left, operators.get(i), right);
            result.addAll(out);
        }
        return result;
    }

    private List<Integer> calculate(List<Integer> left, Character operator, List<Integer> right) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < left.size(); i++) {
            for (int j = 0; j < right.size(); j++) {
                result.add(calculateSingle(left.get(i), operator, right.get(j)));
            }
        }
        return result;
    }

    private Integer calculateSingle(Integer left, Character operator, Integer right) {
        if (operator == '+') {
            return left + right;
        } else if (operator == '-') {
            return left - right;
        } else {
            return left * right;
        }
    }

    private void parseFormula(String input) {
        int nextIndex = 0;
        while (nextIndex < input.length()) {
            int value = 0;
            while (nextIndex < input.length() && input.charAt(nextIndex) >= '0' && input.charAt(nextIndex) <= '9') {
                value = value * 10 + (input.charAt(nextIndex) - '0');
                nextIndex++;
            }
            numbers.add(value);
            if (nextIndex < input.length()) {
                operators.add(input.charAt(nextIndex));
                nextIndex++;
            }
        }
    }
}
