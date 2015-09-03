package leetcode;

import helper.TreeNode;

/**
 * Created by Xinghuang Leon Xu on 8/31/2015.
 */
public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);
        if (leftHeight == rightHeight) {
            return (2<<leftHeight)-1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    private int getLeftHeight(TreeNode temp) {
        if (temp == null) return 0;
        int level = 0;
        while (temp.left != null) {
            level++;
            temp = temp.left;
        }
        return level;
    }

    private int getRightHeight(TreeNode temp) {
        if (temp == null) return 0;
        int level = 0;
        while (temp.right != null) {
            level++;
            temp = temp.right;
        }
        return level;
    }
}
