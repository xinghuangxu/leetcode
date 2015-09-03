package leetcode;

import helper.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Xinghuang Leon Xu on 9/1/2015.
 */
public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> treeNodeQueue = new Stack();
        TreeNode tmp = root;
        while (tmp != null) {
            treeNodeQueue.add(tmp);
            tmp = tmp.left;
        }
        TreeNode result = null;
        while (!treeNodeQueue.isEmpty() && k != 0) {
            tmp = treeNodeQueue.pop();
            k--;
            if (k == 0) {
                return tmp.val;
            }
            if (tmp.right != null) {
                TreeNode right = tmp.right;
                while (right != null) {
                    treeNodeQueue.add(right);
                    right = right.left;
                }
            }
        }
        return result.val;
    }
}
