package leetcode;

import helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xinghuang Leon Xu on 9/3/2015.
 */
public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathToP = new ArrayList();
        findPath(pathToP, root, p);
        List<TreeNode> pathToQ = new ArrayList();
        findPath(pathToQ, root, q);
        int j = 0;
        for (int i = 0; i < pathToP.size() & j < pathToQ.size(); i++, j++) {
            if (pathToP.get(i) != pathToQ.get(j)) {
                break;
            }
        }
        return pathToQ.get(j - 1);
    }

    private void findPath(List<TreeNode> pathToQ, TreeNode root, TreeNode target) {
        if (root.val == target.val) {
            pathToQ.add(target);
        } else if (root.val < target.val) {
            pathToQ.add(root);
            findPath(pathToQ, root.right, target);
        } else {
            pathToQ.add(root);
            findPath(pathToQ, root.left, target);
        }
    }
}
