package leetcode;

import helper.TreeNode;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by xinghuangxu on 3/16/16.
 */
public class BinaryTreeUpsideDownTest extends TestCase {

    @Test
         public void test1() {
        TreeNode root = new TreeNode(1);
        TreeNode leftChild = new TreeNode(2);
        TreeNode rightChild = new TreeNode(3);
        leftChild.left = new TreeNode(4);
        leftChild.right = new TreeNode(5);
        root.left = leftChild;
        root.right = rightChild;
        BinaryTreeUpsideDown binaryTreeUpsideDown = new BinaryTreeUpsideDown();
        TreeNode actualRoot = binaryTreeUpsideDown.upsideDownBinaryTree(root);
        assertEquals(4, actualRoot.val);
        assertEquals(5, actualRoot.left.val);
        assertEquals(2, actualRoot.right.val);
        assertEquals(3, actualRoot.right.left.val);
        assertEquals(1, actualRoot.right.right.val);
    }

    @Test
    public void test4() {
        TreeNode root = new TreeNode(1);
        TreeNode leftChild = new TreeNode(2);

        root.left = leftChild;

        BinaryTreeUpsideDown binaryTreeUpsideDown = new BinaryTreeUpsideDown();
        TreeNode actualRoot = binaryTreeUpsideDown.upsideDownBinaryTree(root);
        assertEquals(2, actualRoot.val);
        assertEquals(null, actualRoot.left.val);
        assertEquals(1, actualRoot.right.val);

    }


    @Test
    public void test2() {

        BinaryTreeUpsideDown binaryTreeUpsideDown = new BinaryTreeUpsideDown();
        TreeNode actualRoot = binaryTreeUpsideDown.upsideDownBinaryTree(null);

    }

    @Test
    public void test3() {

        BinaryTreeUpsideDown binaryTreeUpsideDown = new BinaryTreeUpsideDown();
        TreeNode actualRoot = binaryTreeUpsideDown.upsideDownBinaryTree(new TreeNode(3));

    }

}