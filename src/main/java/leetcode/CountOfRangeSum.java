package leetcode;

/**
 * Created by xinghuangxu on 3/9/16.
 */
public class CountOfRangeSum {

    class TreeNode {
        TreeNode(long value) {
            this.value = value;
            this.treeSize = 1;
        }

        long value;
        int treeSize;
        TreeNode left;
        TreeNode right;

        void insert(TreeNode treeNode) {
            treeSize++;
            if (treeNode.value < value) {
                if (left == null) {
                    left = treeNode;
                } else {
                    left.insert(treeNode);
                }
            } else {
                if (right == null) {
                    right = treeNode;
                } else {
                    right.insert(treeNode);
                }
            }
        }
    }

    private int countGreaterOrEqualToBound(TreeNode treeNode, long bound) {
        if (treeNode == null) return 0;
        if (treeNode.value >= bound) {
            int right = treeNode.right == null ? 0 : treeNode.right.treeSize;
            return countGreaterOrEqualToBound(treeNode.left, bound) + 1 + right;
        } else {
            return countGreaterOrEqualToBound(treeNode.right, bound);
        }
    }

    private int countRange(TreeNode treeNode, long lower, long upper) {
        return countGreaterOrEqualToBound(treeNode, lower) - countGreaterOrEqualToBound(treeNode, upper + 1);
    }

    //nlogn algorithm
    int count;

    public int countRangeSum(int[] nums, int lower, int upper) {
        count = 0;
        int length = nums.length;
        if (length == 0) return count;
        TreeNode[] prefixSums = new TreeNode[length];

        prefixSums[0] = new TreeNode(nums[0]);
        for (int i = 1; i < length; i++) {
            prefixSums[i] = new TreeNode(prefixSums[i - 1].value + nums[i]);
        }

        TreeNode root = prefixSums[length - 1];
        for (int i = length - 1; i > -1; i--) {
            if (i == 0) {
                count += countRange(root, lower, upper);
            } else {
                count += countRange(root, prefixSums[i - 1].value + lower, prefixSums[i - 1].value + upper);
                root.insert(prefixSums[i - 1]);
            }
        }
        return count;
    }

    //n^2 algorithm:

//    int count;
//
//    public int countRangeSum(int[] nums, int lower, int upper) {
//        count = 0;
//        int length = nums.length;
//        if (length == 0) return count;
//        int[] partialSumArray = new int[length];
//
//        partialSumArray[0] = nums[0];
//        increaseCountIfInRange(partialSumArray[0], lower, upper);
//        for (int i = 1; i < length; i++) {
//            partialSumArray[i] = partialSumArray[i - 1] + nums[i];
//            increaseCountIfInRange(partialSumArray[i], lower, upper);
//        }
//        for (int i = 0; i < length - 1; i++) {
//
//            for (int j = i + 1; j < length; j++) {
//                partialSumArray[j] -= nums[i];
//                increaseCountIfInRange(partialSumArray[j], lower, upper);
//            }
//        }
//        return count;
//    }
//
//    private void increaseCountIfInRange(int num, int lower, int upper) {
//        if (num >= lower && num <= upper) {
//            count++;
//        }
//    }
}
