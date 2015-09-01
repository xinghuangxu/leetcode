package leetcode;

import helper.TreeNode;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by Xinghuang Leon Xu on 8/31/2015.
 */
public class CountCompleteTreeNodesTest extends TestCase {
    @Test
    public void test5() {
        int m = 20000;
        TreeNode root = buildCompleteTree(m);
        CountCompleteTreeNodes countCompleteTreeNodes = new CountCompleteTreeNodes();
        int actual = countCompleteTreeNodes.countNodes(root);
        assertEquals(20001, actual);
    }

    private TreeNode buildCompleteTree(int m) {
        int nodeCount = 0;
        Queue<TreeNode> parents = new ArrayDeque<TreeNode>();
        Queue<TreeNode> children = null;
        TreeNode root = new TreeNode(++nodeCount);
        parents.add(root);
        while (nodeCount <= m) {
            children = new ArrayDeque<TreeNode>();
            while (!parents.isEmpty() && nodeCount <= m) {
                TreeNode node = parents.poll();
                node.left = new TreeNode(++nodeCount);
                node.right = new TreeNode(++nodeCount);
                children.add(node.left);
                children.add(node.right);
            }
            parents = children;
        }
        return root;
    }
}