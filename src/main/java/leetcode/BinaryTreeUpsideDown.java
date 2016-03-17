package leetcode;

import helper.TreeNode;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by xinghuangxu on 3/16/16.
 */
public class BinaryTreeUpsideDown {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return null;
        List<TreeNode> treeNodeList = new ArrayList();
        int current = 0;
        treeNodeList.add(root);
        while (treeNodeList.size() > current) {
            TreeNode currentNode = treeNodeList.get(current);
            if (currentNode.left != null) {
                treeNodeList.add(currentNode.left);
            }
            if (currentNode.right != null) {
                treeNodeList.add(currentNode.right);
            }
            currentNode.left = null;
            currentNode.right = null;
            current++;
        }

        return buildTree(treeNodeList, treeNodeList.size() - 2);
    }

    private TreeNode buildTree(List<TreeNode> treeNodeList, int i) {
        if (i == -1) return treeNodeList.get(0);
        if (i < 0 || i >= treeNodeList.size()) return null;
        TreeNode root = treeNodeList.get(i);
        root.left = treeNodeList.get(i + 1);
        root.right = buildTree(treeNodeList, i - 2);
        return root;
    }
}
