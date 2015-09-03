package leetcode;

import helper.TreeNode;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by Xinghuang Leon Xu on 9/3/2015.
 */
public class LowestCommonAncestorOfABinaryTreeTest extends TestCase {

    @Test
    public void test1() {
        LowestCommonAncestorOfABinaryTree lowestCommonAncestorOfABinaryTree = new LowestCommonAncestorOfABinaryTree();
        TreeNode root = new TreeNode(10);
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(15);
        root.left = left;
        root.right = right;
        assertEquals(root, lowestCommonAncestorOfABinaryTree.lowestCommonAncestor(root, left, right));
    }

    @Test
    public void test2() {
        LowestCommonAncestorOfABinaryTree lowestCommonAncestorOfABinaryTree = new LowestCommonAncestorOfABinaryTree();

        TreeNode root3 = new TreeNode(3);
        TreeNode left5 = new TreeNode(5);
        TreeNode right1 = new TreeNode(1);
        root3.left = left5;
        root3.right = right1;
        left5.left = new TreeNode(6);
        left5.right = new TreeNode(2);
        right1.left = new TreeNode(0);
        right1.right = new TreeNode(8);

        assertEquals(root3, lowestCommonAncestorOfABinaryTree.lowestCommonAncestor(root3, left5, right1));
    }

    @Test
    public void test3() {
        LowestCommonAncestorOfABinaryTree lowestCommonAncestorOfABinaryTree = new LowestCommonAncestorOfABinaryTree();

        TreeNode root3 = new TreeNode(3);
        TreeNode left5 = new TreeNode(5);
        TreeNode right1 = new TreeNode(1);
        root3.left = left5;
        root3.right = right1;
        left5.left = new TreeNode(6);
        left5.right = new TreeNode(2);
        right1.left = new TreeNode(0);
        right1.right = new TreeNode(8);

        assertEquals(left5, lowestCommonAncestorOfABinaryTree.lowestCommonAncestor(root3, left5.left, left5.right));
    }

}