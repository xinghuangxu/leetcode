package leetcode;

import java.util.*;

/**
 * Created by k586j642 on 4/14/2016.
 */
public class GraphValidTree {
    boolean hasLoop;

    public boolean validTree(int n, int[][] edges) {
        hasLoop = false;
        Map<Integer, Set<Integer>> graph = new HashMap();

        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet());
        }
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        dfs(graph, 0);
        if (graph.size() > 0) { //need to be strongly connected
            return false;
        }
        if (hasLoop) return false; //no loop
        return true;
    }

    private void dfs(Map<Integer, Set<Integer>> graph, int key) {
        if (!hasLoop&&graph.containsKey(key)) {
            Set<Integer> nodes = graph.get(key);
            graph.remove(key);
            for (Integer n : nodes) {
                graph.get(n).remove(key);
            }
            for (Integer n : nodes) {
               dfs(graph, n);
            }
        } else {
            hasLoop = true;
        }
    }
}
