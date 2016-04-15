package leetcode;

import junit.framework.TestCase;
import org.junit.Test;


/**
 * Created by k586j642 on 4/14/2016.
 */
public class GraphValidTreeTest extends TestCase {
    @Test
    public void test1() {
        GraphValidTree graphValidTree = new GraphValidTree();
        int n = 5;
        int[][] edges = {
                {0, 1},
                {0, 2},
                {2, 3},
                {2, 4}
        };
        assertEquals(true, graphValidTree.validTree(n, edges));
    }
}