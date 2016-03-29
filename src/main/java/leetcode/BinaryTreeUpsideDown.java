package leetcode;

import helper.TreeNode;

import java.util.Deque;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by xinghuangxu on 3/16/16.
 */
public class BinaryTreeUpsideDown {

    //breadth first search with parent reference
    class CompositeTreeNode {

        CompositeTreeNode(TreeNode treeNode, TreeNode parent, TreeNode sibling) {
            this.treeNode = treeNode;
            this.parent = parent;
            this.sibling = sibling;
        }

        TreeNode treeNode;
        TreeNode parent;
        TreeNode sibling;
    }

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return null;
        Stack<CompositeTreeNode> compositeTreeNodes = new Stack();
        compositeTreeNodes.push(new CompositeTreeNode(root, null, null));
        while (true) {
            CompositeTreeNode parent = compositeTreeNodes.pop();
            if (parent.treeNode.left != null) {
                compositeTreeNodes.push(new CompositeTreeNode(parent.treeNode.left, parent.treeNode, parent.treeNode.right));
            }
            parent.treeNode.right = parent.parent;
            parent.treeNode.left = parent.sibling;
            if (compositeTreeNodes.empty()) {
                return parent.treeNode;
            }
        }
    }

}
