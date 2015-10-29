package leetcode;

import helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xinghuang Leon Xu on 10/26/2015.
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode node) {
        List<String> binaryTreePaths = new ArrayList<String>();
        if (node == null) {
            return binaryTreePaths;
        }
        String prefix = node.val + "->";
        List<String> leftBinaryTreePaths = binaryTreePaths(node.left);
        List<String> rightBinaryTreePaths = binaryTreePaths(node.right);
        for (int i = 0; i < leftBinaryTreePaths.size(); i++) {
            binaryTreePaths.add(prefix + leftBinaryTreePaths.get(i));
        }
        for (int i = 0; i < rightBinaryTreePaths.size(); i++) {
            binaryTreePaths.add(prefix + rightBinaryTreePaths.get(i));
        }
        if (leftBinaryTreePaths.size() == 0 && rightBinaryTreePaths.size() == 0) {
            binaryTreePaths.add(node.val + "");
        }
        return binaryTreePaths;
    }
}
