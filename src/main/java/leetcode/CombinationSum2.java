package leetcode;

import java.util.*;

/**
 * Created by xinghuangxu on 4/10/16.
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result;
        result = findCombinationSum(candidates,target,candidates.length-1);
        return result;
    }

    private List<List<Integer>> findCombinationSum(int[] candidates, int target, int hi) {
        List<List<Integer>> result = new ArrayList();
        for(int i=hi;i>-1;){
            if(candidates[i]==target){
                result.add(new ArrayList<Integer>());
                result.get(result.size()-1).add(target);
            }else if(target>=candidates[i]){
                List<List<Integer>> tmp = findCombinationSum(candidates,target-candidates[i],i-1);
                if(tmp.size()>0){
                    for(List<Integer> list : tmp){
                        list.add(candidates[i]);
                        result.add(list);
                    }
                }
            }
            i--;
            while(i>-1 && candidates[i+1]==candidates[i]){
                i--;
            }
        }
        return result;
    }
}
