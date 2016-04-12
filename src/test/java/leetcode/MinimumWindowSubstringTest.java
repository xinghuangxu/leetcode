package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by k586j642 on 3/25/2016.
 */
public class MinimumWindowSubstringTest extends TestCase {
    @Test
    public void test1() {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String expected = "BANC";
        assertEquals(expected, minimumWindowSubstring.minWindow(s, t));
    }

    @Test
    public void test2() {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        String s = "a";
        String t = "aa";
        String expected = "";
        assertEquals(expected, minimumWindowSubstring.minWindow(s, t));
    }

    @Test
    public void test3() {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        String s = "a";
        String t = "b";
        String expected = "";
        assertEquals(expected, minimumWindowSubstring.minWindow(s, t));
    }
}