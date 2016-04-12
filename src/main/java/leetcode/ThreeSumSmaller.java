package leetcode;

/**
 * Created by xinghuangxu on 4/6/16.
 */
public class ThreeSumSmaller {

    class TreeNode {
        int value;
        int count = 1;
        int childrenCount = 0;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
        }

        void addChild(TreeNode child) {
            if (child.value == value) count++;
            else if (child.value < value) {
                if (left != null) left.addChild(child);
                else
                    left = child;
                childrenCount += child.count;
            } else {
                if (right != null) right.addChild(child);
                else
                    right = child;
                childrenCount += child.count;
            }
        }

        public int findSmallerCount(int target) {
            if (this.value == target) {
                return (left != null ? (left.count + left.childrenCount) : 0);
            } else if (this.value < target) {
                return this.count + (left != null ? (left.count + left.childrenCount) : 0) + (right != null ? (right.findSmallerCount(target)) : 0);
            } else {
                return left != null ? this.left.findSmallerCount(target) : 0;
            }
        }
    }


    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) return 0;
        TreeNode root = null;
        int count = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            for (int j = 0; j < i; j++) {
                //add nums[i] + nums[j] to the binary tree
                if (root != null) {
                    root.addChild(new TreeNode(nums[i] + nums[j]));
                }else{
                    root = new TreeNode(nums[i] + nums[j]);
                }
            }
            int tnum = nums[i + 1];
            count += root.findSmallerCount(target - tnum);
        }
        return count;
    }
}
