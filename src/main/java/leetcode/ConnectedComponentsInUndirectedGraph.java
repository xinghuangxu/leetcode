package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by k586j642 on 4/14/2016.
 */
public class ConnectedComponentsInUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        int numComponent = 0;
        //build the graph
        Map<Integer, List<Integer>> map = new HashMap();
        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int x = edge[0], y = edge[1];
            map.get(x).add(y);
            map.get(y).add(x);
        }
        for(int i=0;i<n;i++){
            if(map.containsKey(i)){
                numComponent++;
                dfs(map,i);
            }
        }
        return numComponent;
    }

    private void dfs(Map<Integer, List<Integer>> map, int i) {
        if(map.containsKey(i)){
            List<Integer> nodes = map.get(i);
            map.remove(i);
            for(Integer n:nodes){
                dfs(map,n);
            }
        }
    }
}
