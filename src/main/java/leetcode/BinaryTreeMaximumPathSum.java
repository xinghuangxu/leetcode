package leetcode;

import helper.TreeNode;

/**
 * Created by xinghuangxu on 4/11/16.
 */
public class BinaryTreeMaximumPathSum {

    int max;

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        int value = getMaxPathSum(root);
        return Math.max(max, value);
    }

    private int getMaxPathSum(TreeNode node) {
        if (node == null) return 0;
        int left = getMaxPathSum(node.left);
        int right = getMaxPathSum(node.right);
        int sum = node.val + Math.max(0, left) + Math.max(0, right);
        ;
        if (max < sum) {
            max = sum;
        }
        return node.val + Math.max(0, Math.max(left, right));
    }
}
