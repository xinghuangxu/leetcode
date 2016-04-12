package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xinghuangxu on 4/10/16.
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result;
        result = findCombination(k, n);
        return result;
    }

    private List<List<Integer>> findCombination(int k, int hi) {
        List<List<Integer>> result = new ArrayList();
        for (int i = hi; i > 0; i--) {
            if (k == 1) {
                result.add(new ArrayList<Integer>());
                result.get(result.size() - 1).add(i);
            } else {
                List<List<Integer>> tmp = findCombination(k - 1, i-1);
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
