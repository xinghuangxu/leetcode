package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by xinghuangxu on 2/29/16.
 */
public class VerifyPreorderSerializationBinaryTreeTest extends TestCase {

    @Test
    public void test1() {
        VerifyPreorderSerializationBinaryTree verifyPreorderSerializationBinaryTree = new VerifyPreorderSerializationBinaryTree();
        assertTrue(verifyPreorderSerializationBinaryTree.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }

    @Test
    public void test2() {
        VerifyPreorderSerializationBinaryTree verifyPreorderSerializationBinaryTree = new VerifyPreorderSerializationBinaryTree();
        assertFalse(verifyPreorderSerializationBinaryTree.isValidSerialization("1,#"));
    }

    @Test
    public void test3() {
        VerifyPreorderSerializationBinaryTree verifyPreorderSerializationBinaryTree = new VerifyPreorderSerializationBinaryTree();
        assertFalse(verifyPreorderSerializationBinaryTree.isValidSerialization("9,#,#,1"));
    }


}