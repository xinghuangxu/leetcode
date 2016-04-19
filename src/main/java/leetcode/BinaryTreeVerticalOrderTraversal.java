package leetcode;

import helper.TreeNode;

import java.util.HashMap;
import java.util.*;
import java.util.Map;

/**
 * Created by xinghuangxu on 4/16/16.
 */
public class BinaryTreeVerticalOrderTraversal {

    class TreeNodeWithColumnNumber {
        int columnNumber;
        TreeNode treeNode;

        TreeNodeWithColumnNumber(int columnNumber, TreeNode treeNode) {
            this.columnNumber = columnNumber;
            this.treeNode = treeNode;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> columnListMap = new HashMap();
        traverseTheTree(columnListMap, root);
        List<List<Integer>> result = new ArrayList(columnListMap.size());
        int min = Integer.MAX_VALUE;
        for (Integer key : columnListMap.keySet()) {
            if (key < min) {
                min = key;
            }
            result.add(null);
        }
        min = -1 * min;
        for (Integer key : columnListMap.keySet()) {
            result.set(key + min, columnListMap.get(key));
        }
        return result;
    }

    private void traverseTheTree(Map<Integer, List<Integer>> columnListMap, TreeNode treeNode) {
        Queue<TreeNodeWithColumnNumber> queue = new ArrayDeque<TreeNodeWithColumnNumber>();
        queue.add(new TreeNodeWithColumnNumber(0, treeNode));

        while (!queue.isEmpty()) {
            TreeNodeWithColumnNumber tmp = queue.poll();
            if (tmp.treeNode != null) {
                if (!columnListMap.containsKey(tmp.columnNumber)) {
                    columnListMap.put(tmp.columnNumber, new ArrayList());
                }
                columnListMap.get(tmp.columnNumber).add(tmp.treeNode.val);
                queue.add(new TreeNodeWithColumnNumber(tmp.columnNumber - 1, tmp.treeNode.left));
                queue.add(new TreeNodeWithColumnNumber(tmp.columnNumber + 1, tmp.treeNode.right));
            }
        }
    }
}
