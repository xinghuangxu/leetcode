package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by k586j642 on 4/15/2016.
 */
public class BestMeetingPointTest extends TestCase {
    @Test
    public void test1() {
        BestMeetingPoint bestMeetingPoint = new BestMeetingPoint();
        int[][] grid = {
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0}
        };
        assertEquals(6, bestMeetingPoint.minTotalDistance(grid));
    }
}