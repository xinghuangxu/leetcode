package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by k586j642 on 3/25/2016.
 */
public class LongestSubstringWithoutRepeatingCharactersTest extends TestCase {
    @Test
    public void test1() {
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters
                = new LongestSubstringWithoutRepeatingCharacters();
        String s = "abcabcbb";
        int expected = 3;
        assertEquals(expected, longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s));
    }
}