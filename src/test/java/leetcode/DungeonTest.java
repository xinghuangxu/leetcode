package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by k586j642 on 4/18/2016.
 */
public class DungeonTest extends TestCase {
    @Test
    public void test1() {
        Dungeon dungeon = new Dungeon();
        int[][] dungeons = {
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        };
        assertEquals(7,dungeon.calculateMinimumHP(dungeons));
    }
}