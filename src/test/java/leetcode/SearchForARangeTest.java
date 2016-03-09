package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by k586j642 on 3/9/2016.
 */
public class SearchForARangeTest extends TestCase {
    @Test
    public void test1() {
        int[] data = new int[]{5, 7, 7, 8, 8, 10};
        SearchForARange searchForARange = new SearchForARange();
        int[] actual = searchForARange.searchRange(data,8);
        assertEquals(2,actual.length);
        assertEquals(3,actual[0]);
        assertEquals(4,actual[1]);
    }
}