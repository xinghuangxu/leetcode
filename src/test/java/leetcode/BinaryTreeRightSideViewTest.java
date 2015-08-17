package leetcode;

import helper.TreeNode;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;


/**
 * Created by xinghuangxu on 8/2/15.
 */
public class BinaryTreeRightSideViewTest extends TestCase {

    @Test
    public void test1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        BinaryTreeRightSideView binaryTreeRightSideView = new BinaryTreeRightSideView();
        List<Integer> rightSideView = binaryTreeRightSideView.rightSideView(root);
        Integer[] expected = new Integer[]{1, 3};
        for(int i=0;i<expected.length;i++){
            assertEquals(expected[i],rightSideView.get(i));
        }
    }
}