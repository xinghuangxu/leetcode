package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by xinghuangxu on 3/24/16.
 */
public class RemoveDuplicateLettersTest extends TestCase {
    /*
    Given "bcabc"
    Return "abc"

    Given "cbacdcbc"
    Return "acdb"
     */
    @Test
    public void test1() {
        RemoveDuplicateLetters removeDuplicateLetters = new RemoveDuplicateLetters();
        String s = "bcabc";
        String actual = removeDuplicateLetters.removeDuplicateLetters(s);
        String expected = "abc";
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        RemoveDuplicateLetters removeDuplicateLetters = new RemoveDuplicateLetters();
        String s = "cbacdcbc";
        String actual = removeDuplicateLetters.removeDuplicateLetters(s);
        String expected = "acdb";
        assertEquals(expected, actual);
    }

    //"rusrbofeggbbkyuyjsrzornpdguwzizqszpbicdquakqws"
    @Test
    public void test3() {
        RemoveDuplicateLetters removeDuplicateLetters = new RemoveDuplicateLetters();
        String s = "rusrbofeggbbkyuyjsrzornpdguwzizqszpbicdquakqws";
        String actual = removeDuplicateLetters.removeDuplicateLetters(s);
        String expected = "bfegkuyjorndiqszpcaw";
        assertEquals(expected, actual);
    }
}