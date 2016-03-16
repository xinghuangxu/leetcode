package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

/**
 * Created by k586j642 on 3/16/2016.
 */
public class PalindromePairsTest extends TestCase {
    @Test
    public void test1() {
        PalindromePairs palindromePairs = new PalindromePairs();
        String[] words = new String[]{"bat", "tab", "cat"};
        List<List<Integer>> actual = palindromePairs.palindromePairs(words);
        Integer[][] expected = new Integer[][]{{0, 1}, {1, 0}};
        assertListArrayEquals(actual, expected);
    }

    @Test
    public void test2() {
        PalindromePairs palindromePairs = new PalindromePairs();
        String[] words = new String[]{"abcd", "dcba", "lls", "s", "sssll"};
        List<List<Integer>> actual = palindromePairs.palindromePairs(words);
        Integer[][] expected = new Integer[][]{{0, 1}, {1, 0}, {3, 2}, {2, 4}};
        assertListArrayEquals(actual, expected);
    }

    @Test
    public void test3() {
        PalindromePairs palindromePairs = new PalindromePairs();
        String[] words = new String[]{"a", ""};
        List<List<Integer>> actual = palindromePairs.palindromePairs(words);
        Integer[][] expected = new Integer[][]{{0, 1}, {1, 0}};
        assertListArrayEquals(actual, expected);
    }

    private void assertListArrayEquals(List<List<Integer>> list, Integer[][] array) {
        assertEquals(list.size(), array.length);
        for (int i = 0; i < list.size(); i++) {
            assertEquals(list.get(i).size(), array[i].length);
            for (int j = 0; j < 2; j++) {
                assertEquals(list.get(i).get(j), array[i][j]);
            }
        }
    }
}