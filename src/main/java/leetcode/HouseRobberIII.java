package leetcode;

import helper.TreeNode;

/**
 * Created by k586j642 on 3/16/2016.
 */
public class HouseRobberIII {
    public int rob(TreeNode root) {
        if (root == null) return 0;
        //rob root and the next level of children
        int robRootTotal = root.val;
        if (root.left != null) {
            robRootTotal += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            robRootTotal += rob(root.right.left) + rob(root.right.right);
        }
        int robChildTotal = rob(root.left) + rob(root.right);
        return Math.max(robRootTotal, robChildTotal);
    }
}
