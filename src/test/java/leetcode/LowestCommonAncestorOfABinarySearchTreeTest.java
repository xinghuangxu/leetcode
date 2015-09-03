package leetcode;

import helper.TreeNode;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

/**
 * Created by Xinghuang Leon Xu on 9/3/2015.
 */
public class LowestCommonAncestorOfABinarySearchTreeTest extends TestCase {
    @Test
    public void test1() {
        LowestCommonAncestorOfABinarySearchTree lowestCommonAncestorOfABinarySearchTree = new LowestCommonAncestorOfABinarySearchTree();
        TreeNode root = new TreeNode(10);
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(15);
        root.left = left;
        root.right = right;
        assertEquals(root, lowestCommonAncestorOfABinarySearchTree.lowestCommonAncestor(root, left, right));
    }

    @Test
    public void test2() {
        LowestCommonAncestorOfABinarySearchTree lowestCommonAncestorOfABinarySearchTree = new LowestCommonAncestorOfABinarySearchTree();
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        root.left = left;
        root.right = null;
        assertEquals(root, lowestCommonAncestorOfABinarySearchTree.lowestCommonAncestor(root, left, root));
    }
}