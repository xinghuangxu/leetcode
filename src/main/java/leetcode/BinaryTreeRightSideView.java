package leetcode;

import helper.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xinghuangxu on 8/2/15.
 */
public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSideView = new ArrayList<Integer>();
        if(root==null) return rightSideView;
        Queue<TreeNode> treeNodeQueue = new ArrayDeque<TreeNode>();
        Queue<Integer> levelQueues = new ArrayDeque<Integer>();
        treeNodeQueue.add(root);
        levelQueues.add(0);
        while (!treeNodeQueue.isEmpty()) {
            TreeNode treenode = treeNodeQueue.poll();
            Integer level = levelQueues.poll();
            if (treeNodeQueue.isEmpty() || levelQueues.peek() > level) {
                rightSideView.add(treenode.val);
            }
            if(treenode.left!=null){
                treeNodeQueue.add(treenode.left);
                levelQueues.add(level+1);
            }
            if(treenode.right !=null){
                treeNodeQueue.add(treenode.right);
                levelQueues.add(level+1);
            }
        }
        return rightSideView;
    }


    class LevelNode {
        public int level;
        public TreeNode treenode;

        public LevelNode(int level, TreeNode treenode) {
            this.level = level;
            this.treenode = treenode;
        }
    }

    /**
     * This version is less efficient because it creates too many LevelNode objects.
     * @param root
     * @return
     */
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> rightSideView = new ArrayList<Integer>();
        if(root==null) return rightSideView;
        Queue<LevelNode> levelNodeQueue = new ArrayDeque<LevelNode>();
        levelNodeQueue.add(new LevelNode(0, root));
        while (!levelNodeQueue.isEmpty()) {
            LevelNode levelNode = levelNodeQueue.poll();
            if (levelNodeQueue.isEmpty() || levelNodeQueue.peek().level > levelNode.level) {
                rightSideView.add(levelNode.treenode.val);
            }
            if(levelNode.treenode.left!=null){
                levelNodeQueue.add(new LevelNode(levelNode.level+1,levelNode.treenode.left));
            }
            if(levelNode.treenode.right !=null){
                levelNodeQueue.add(new LevelNode(levelNode.level+1,levelNode.treenode.right));
            }
        }
        return rightSideView;
    }
}
