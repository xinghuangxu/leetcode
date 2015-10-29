package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by xinghuangxu on 9/20/15.
 */
public class WordSearchIITest extends TestCase {

    @Test
    public void test1() {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};
        WordSearchII wordSearchII = new WordSearchII();
        assertArrayEquals(new String[]{"oath","eat" }, wordSearchII.findWords(board, words).toArray());
    }



}