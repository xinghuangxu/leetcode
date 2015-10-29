package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by Xinghuang Leon Xu on 9/4/2015.
 */
public class ValidAnagramTest extends TestCase {
    @Test
    public void test1() {
        ValidAnagram validAnagram = new ValidAnagram();
        assertEquals(true, validAnagram.isAnagram("anagram", "nagaram"));
    }

    @Test
    public void test2() {
        ValidAnagram validAnagram = new ValidAnagram();
        assertEquals(false, validAnagram.isAnagram("rat", "car"));
    }
}