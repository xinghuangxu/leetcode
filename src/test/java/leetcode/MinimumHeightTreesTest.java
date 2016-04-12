package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

/**
 * Created by xinghuangxu on 3/31/16.
 */
public class MinimumHeightTreesTest extends TestCase {
    @Test
    public void test1(){
        int n = 4;
        int[][] edges = {{1, 0}, {1, 2}, {1, 3}};
        MinimumHeightTrees minimumHeightTrees = new MinimumHeightTrees();
        List<Integer> actual = minimumHeightTrees.findMinHeightTrees(n,edges);
    }


    @Test
    public void test2(){
        int n = 5000;
        int[][] edges = new int[n-1][2];
        for(int i=0;i<n-1;i++){
            edges[i][0]=i;
            edges[i][1]=i+1;
        }
        MinimumHeightTrees minimumHeightTrees = new MinimumHeightTrees();
        List<Integer> actual = minimumHeightTrees.findMinHeightTrees(n,edges);
    }


    @Test
    public void test3(){
        int n = 50;
        int[][] edges = new int[n-1][2];
        for(int i=0;i<n-1;i++){
            edges[i][0]=i;
            edges[i][1]=i+1;
        }
        MinimumHeightTrees minimumHeightTrees = new MinimumHeightTrees();
        List<Integer> actual = minimumHeightTrees.findMinHeightTrees(n,edges);
    }

    @Test
    public void test4(){
        int n = 1;
        MinimumHeightTrees minimumHeightTrees = new MinimumHeightTrees();
        List<Integer> actual = minimumHeightTrees.findMinHeightTrees(n,new int[0][0]);
    }
}