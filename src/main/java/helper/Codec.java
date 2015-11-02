package helper;

/**
 * Created by Xinghuang Leon Xu on 11/1/2015.
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "()";
        StringBuilder sb = new StringBuilder();
        return "(" + root.val + serialize(root.left) + serialize(root.right) + ")";
    }

    class InterResult {
        InterResult(int endIndex, TreeNode node) {
            this.endIndex = endIndex;
            this.node = node;
        }
        int endIndex;
        TreeNode node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserializeWithStartIndex(data, 1).node;
    }

    private InterResult deserializeWithStartIndex(String data, int i) {
        String num = "";
        while (data.charAt(i) != '(' && data.charAt(i) != ')') {
            num += data.charAt(i);
            i++;
        }
        if (num.equals("")) {
            return new InterResult(i + 1, null);
        }
        int val = Integer.parseInt(num);
        InterResult left = deserializeWithStartIndex(data, i + 1);
        InterResult right = deserializeWithStartIndex(data, left.endIndex + 1);
        TreeNode result = new TreeNode(val);
        result.left = left.node;
        result.right = right.node;
        return new InterResult(right.endIndex + 1, result);
    }
}
