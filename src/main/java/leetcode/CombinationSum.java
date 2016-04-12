package leetcode;


import java.util.Arrays;
import java.util.*;

/**
 * Created by xinghuangxu on 4/7/16.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList();
        findCombinationSum(candidates, result, target, candidates.length - 1);
        return result;
    }

    private void findCombinationSum(int[] candidates, List<List<Integer>> result, int target, int end) {
        List<List<Integer>> tmp = new ArrayList(); // contains all the collected result to be added back to result
        for (int i = end; i > -1; i++) {
            if(target>candidates[i]){
                findCombinationSum(candidates,tmp,target-candidates[i],end);
            }else if(target==candidates[i]){
                List<Integer> tmpList = new ArrayList<Integer>(1);
                tmp.add(tmpList);
            }
        }
    }
}
