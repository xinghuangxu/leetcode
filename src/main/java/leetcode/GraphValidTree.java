package leetcode;

import java.util.*;

/**
 * Created by k586j642 on 4/14/2016.
 */
public class GraphValidTree {

    //union-find
    class UnionFind {

        int[] parent;
        int[] rank;
        int size;

        UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            rank = new int[n];
            size = n;
        }

        int find(int x) {// find with path compression
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        //return false if x and y in the same union
        //union by rank, rank is the size of the tree
        boolean union(int x, int y) {
            int xParent = find(x), yParent = find(y);
            if (xParent == yParent) {
                return false;
            }
            int xRank = rank[xParent], yRank = rank[yParent];
            if (xRank > yRank) {
                parent[yParent] = xParent;
            } else if (xRank < yRank) {
                parent[xParent] = yParent;
            } else {
                rank[yParent] += rank[xParent];
                parent[xParent] = yParent;
            }
            size--;
            return true;
        }
    }

    //union-find driver
//    public boolean validTree(int n, int[][] edges) {
//        //union find
//        UnionFind unionFind = new UnionFind(n);
//        for (int[] edge : edges) {
//            int x = edge[0], y = edge[1];
//            if (!unionFind.union(x, y)) {
//                return false;
//            }
//        }
//        return unionFind.size == 1;
//    }

//    //dfs driver
//    public boolean validTree(int n, int[][] edges) {
//        //union find
//        List<List<Integer>> graph = new ArrayList();
//        for (int i = 0; i < n; i++) {
//            graph.add(new ArrayList());
//        }
//        for (int[] edge : edges) {
//            int x = edge[0], y = edge[1];
//            graph.get(x).add(y);
//            graph.get(y).add(x);
//        }
//        boolean[] visited = new boolean[n];
//        if (hasCycle(graph, 0, visited, -1)) {
//            return false;
//        }
//        for(boolean v:visited){
//            if(!v)return false;
//        }
//        return true;
//    }

    //using depth first search: return true if has cycle
    private boolean hasCycle(List<List<Integer>> graph, int vertex, boolean[] visited, int parent) {
        visited[vertex] = true;
        List<Integer> children = graph.get(vertex);
        for (int c : children) {
            if (!visited[c]) {
                if (hasCycle(graph, c, visited, vertex)) {
                    return true;
                }
            } else if (c != parent) {
                return true;
            }
        }
        return false;
    }

    //bfs driver
    public boolean validTree(int n, int[][] edges) {
        //union find
        List<List<Integer>> graph = new ArrayList();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList());
        }
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        int[] visited = new int[n];
        visited[0] = 1;
        Queue<Integer> queue = new ArrayDeque<Integer>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            List<Integer> children = graph.get(vertex);
            for (Integer c : children) {
                if (visited[c] == 1) return false;
                else if (visited[c] == 0) {
                    visited[c] = 1;
                    queue.add(c);
                }
            }
            visited[vertex] = 2;
        }
        for (int v : visited) {
            if (v != 2) return false;
        }
        return true;
    }
}
