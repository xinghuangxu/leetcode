package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Xinghuang Leon Xu on 9/4/2015.
 */
public class SummaryRangesTest extends TestCase {

    @Test
    public void test1() {
        SummaryRanges summaryRanges = new SummaryRanges();
        assertArrayEquals(new String[]{"0->2", "4->5", "7"}, summaryRanges.summaryRanges(new int[]{0, 1, 2, 4, 5, 7}).toArray());
    }

}