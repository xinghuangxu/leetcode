package leetcode;

import helper.TreeNode;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by k586j642 on 3/16/2016.
 */
public class HouseRobberIIITest extends TestCase {
    @Test
    public void test1() {
        TreeNode root = new TreeNode(3);
        TreeNode leftChild = new TreeNode(2);
        TreeNode rightChild = new TreeNode(3);
        leftChild.right = new TreeNode(3);
        rightChild.right = new TreeNode(1);
        root.left = leftChild;
        root.right = rightChild;
        HouseRobberIII houseRobberIII = new HouseRobberIII();
        assertEquals(7, houseRobberIII.rob(root));
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(3);
        TreeNode leftChild = new TreeNode(4);
        TreeNode rightChild = new TreeNode(5);
        leftChild.right = new TreeNode(3);
        leftChild.left = new TreeNode(1);
        rightChild.right = new TreeNode(1);
        root.left = leftChild;
        root.right = rightChild;
        HouseRobberIII houseRobberIII = new HouseRobberIII();
        assertEquals(9, houseRobberIII.rob(root));
    }
}