package leetcode;

import helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xinghuang Leon Xu on 9/2/2015.
 */
public class LowestCommonAncestorOfABinaryTree {

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

    private boolean findPath(List<TreeNode> pathToQ, TreeNode root, TreeNode target) {
        if (root == null) return false;
        pathToQ.add(root);
        if (root == target) {
            return true;
        }
        if (findPath(pathToQ, root.right, target) || findPath(pathToQ, root.left, target)) {
            return true;
        }
        pathToQ.remove(root);
        return false;
    }
}
