package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by xinghuangxu on 3/30/16.
 */
public class CountOfSmallerNumbersAfterSelf {

    class TreeNode {
        int childCount = 0;
        TreeNode left, right;
        int value;

        TreeNode(int value) {
            this.value = value;
        }

        void addChild(TreeNode treeNode) {
            if (treeNode.value < this.value) {
                if (left != null) {
                    left.addChild(treeNode);
                } else {
                    left = treeNode;
                }
            } else {
                if (right != null) {
                    right.addChild(treeNode);
                } else {
                    right = treeNode;
                }
            }
            childCount++;
        }

        int findLessCount(int value) {
            if (value >= this.value) {
                int leftCount = left == null ? 0 : left.childCount + 1;
                int rightCount = right == null ? 0 : right.findLessCount(value);
                if (value == this.value) {
                    return leftCount + rightCount;
                } else {
                    return leftCount + rightCount + 1;
                }
            } else {
                return left == null ? 0 : left.findLessCount(value);
            }
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new LinkedList();
        if (nums.length == 0) return result;
        TreeNode root = new TreeNode(nums[nums.length - 1]);
        result.add(0);
        for (int i = nums.length - 2; i > -1; i--) {
            int lessCount = root.findLessCount(nums[i]);
            result.add(0, lessCount);
            root.addChild(new TreeNode(nums[i]));
        }
        return result;
    }
}
