package leetcode;

import java.util.Arrays;
import java.util.*;

/**
 * Created by xinghuangxu on 4/7/16.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result;
        result = findCombinationSum(candidates,target,candidates.length-1);
        return result;
    }

    private List<List<Integer>> findCombinationSum(int[] candidates, int target, int hi) {
        List<List<Integer>> result = new ArrayList();
        for(int i=0;i<=hi&&target>=candidates[i];i++){
            if(candidates[i]==target){
                result.add(new ArrayList<Integer>());
                result.get(result.size()-1).add(target);
            }else{
                List<List<Integer>> tmp = findCombinationSum(candidates,target-candidates[i],i);
                if(tmp.size()>0){
                    for(List<Integer> list : tmp){
                        list.add(candidates[i]);
                        result.add(list);
                    }
                }
            }
        }
        return result;
    }
}
