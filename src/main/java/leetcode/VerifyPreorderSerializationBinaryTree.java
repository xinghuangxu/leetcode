package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by xinghuangxu on 2/29/16.
 */
public class VerifyPreorderSerializationBinaryTree {

    public boolean isValidSerialization(String preorder) {
        List<String> preorderCharArray = new LinkedList();
        String[] items = preorder.split(",");
        for(int i=items.length-1;i>=0;i--){
            preorderCharArray.add(items[i]);
        }
        boolean continueGoing = true;
        while(continueGoing){
            int cur = findNonEmptyIndex(preorderCharArray);
            if(cur!=-1 && cur>=2){
                preorderCharArray.remove(cur);
                preorderCharArray.remove(0);
            }else{
                continueGoing = false;
            }
        }

        if(preorderCharArray.size()==1 && preorderCharArray.get(0).equals("#")){
            return true;
        }
        return false;
    }

    private int findNonEmptyIndex(List<String> preorderCharArray) {
        int start = 0;
        while(preorderCharArray.size()>start){
            if(!preorderCharArray.get(start).equals("#"))
                return start;
            start ++;
        }
        return -1;
    }

}
