package leetcode;

import java.util.*;

/**
 * Created by xinghuangxu on 3/31/16.
 */
public class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer,Set<Integer>> maps = new HashMap<Integer, Set<Integer>>();

        for (int i = 0; i < edges.length; i++) {
            if(!maps.containsKey(edges[i][0])){
                maps.put(edges[i][0],new HashSet<Integer>());
            }
            if(!maps.containsKey(edges[i][1])){
                maps.put(edges[i][1],new HashSet<Integer>());
            }
            maps.get(edges[i][0]).add(edges[i][1]);
            maps.get(edges[i][1]).add(edges[i][0]);
        }
        List<Integer> queue = new ArrayList<Integer>();
        for (int key : maps.keySet()) {
            if(maps.get(key).size()<=1){
                queue.add(key);
            }
        }
        if(queue.isEmpty()){
            queue.add(0);
            return queue;
        }
        List<Integer> tmp;
        while (true) {
            tmp = new ArrayList();
            for(int i=0;i<queue.size();i++){
                int node = queue.get(i);
                //get the connected node
                Set<Integer> set = maps.get(node);
                for(Integer connected :set){
                    maps.get(connected).remove(node);
                    if(maps.get(connected).size()==1){
                        tmp.add(connected);
                    }
                }
            }
            if(tmp.isEmpty())return queue;
            queue = tmp;
        }
    }
}
