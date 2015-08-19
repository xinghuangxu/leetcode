package leetcode;

import helper.Trie;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by xinghuangxu on 8/18/15.
 */
public class ImplementTrieTest {
    @Test
    public void test1() {
        Trie trie = new Trie();
        trie.insert("somestring");
        assertEquals(false, trie.search("key"));
        assertEquals(true, trie.search("somestring"));
    }
}