package leetcode;

import helper.TreeNode;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

/**
 * Created by Xinghuang Leon Xu on 9/1/2015.
 */
public class KthSmallestElementInABSTTest extends TestCase {
    @Test
    public void test1() {
        KthSmallestElementInABST kthSmallestElementInABST = new KthSmallestElementInABST();
        int actual = kthSmallestElementInABST.kthSmallest(new TreeNode(10),1);
        assertEquals(10,actual);
    }
}