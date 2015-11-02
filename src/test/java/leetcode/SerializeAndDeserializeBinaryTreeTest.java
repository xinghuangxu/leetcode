package leetcode;

import helper.Codec;
import helper.TreeNode;
import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Xinghuang Leon Xu on 11/1/2015.
 */
public class SerializeAndDeserializeBinaryTreeTest extends TestCase {
    @Test
    public void test1() {
        Codec codec = new Codec();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String result = codec.serialize(root);
        TreeNode actual = codec.deserialize(result);
    }
}