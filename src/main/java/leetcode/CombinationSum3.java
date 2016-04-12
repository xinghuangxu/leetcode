package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xinghuangxu on 4/10/16.
 */
public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result;
        result = findCombinationSum(k, n, 9);
        return result;
    }

    private List<List<Integer>> findCombinationSum(int k, int target, int hi) {
        if (k == 0) return null;
        List<List<Integer>> result = new ArrayList();
        for (int i = hi; i > 0; i--) {
            if (i == target && k == 1) {
                result.add(new ArrayList<Integer>());
                result.get(result.size() - 1).add(target);
            } else if (target >= i) {
                List<List<Integer>> tmp = findCombinationSum(k - 1, target - i, i-1);
                if (tmp != null && tmp.size() > 0) {
                    for (List<Integer> list : tmp) {
                        list.add(i);
                        result.add(list);
                    }
                }
            }
        }
        return result;
    }
}
