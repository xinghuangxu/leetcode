package leetcode;

import helper.WordDictionary;
import helper.WordDictionary2;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xinghuangxu on 8/19/15.
 */
public class AddAndSearchWordTest {

    @Test
    public void test1() {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        assertEquals(false, wordDictionary.search("pad"));
        assertEquals(true, wordDictionary.search("bad"));
        assertEquals(true, wordDictionary.search(".ad"));
        assertEquals(true, wordDictionary.search("b.."));
    }

    @Test
    public void test2() {
        WordDictionary2 wordDictionary = new WordDictionary2();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        assertEquals(false, wordDictionary.search("pad"));
        assertEquals(true, wordDictionary.search("bad"));
        assertEquals(true, wordDictionary.search(".ad"));
        assertEquals(true, wordDictionary.search("b.."));
    }

}