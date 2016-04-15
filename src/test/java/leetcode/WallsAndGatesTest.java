package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by k586j642 on 4/14/2016.
 */
public class WallsAndGatesTest extends TestCase {
    @Test
    public void test1() {
        WallsAndGates wallsAndGates = new WallsAndGates();
        int[][] rooms = new int[][]{
                {2147483647, -1, 0, 2147483647},
                {2147483647, 2147483647, 2147483647, -1},
                {2147483647, -1, 2147483647, -1},
                {0, -1, 2147483647, 2147483647},
        };
        wallsAndGates.wallsAndGates(rooms);
    }
}