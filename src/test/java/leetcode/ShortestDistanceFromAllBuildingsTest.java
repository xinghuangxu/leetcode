package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by k586j642 on 4/15/2016.
 */
public class ShortestDistanceFromAllBuildingsTest extends TestCase {
    @Test
    public void test1() {
        ShortestDistanceFromAllBuildings shortestDistanceFromAllBuildings = new ShortestDistanceFromAllBuildings();
        int[][] grid = {
                {1, 0, 2, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0}
        };
        assertEquals(7, shortestDistanceFromAllBuildings.shortestDistance(grid));
    }

    @Test
    public void test2() {
        ShortestDistanceFromAllBuildings shortestDistanceFromAllBuildings = new ShortestDistanceFromAllBuildings();
        int[][] grid = {
                {1, 2, 0}
        };
        assertEquals(-1, shortestDistanceFromAllBuildings.shortestDistance(grid));
    }

    @Test
    public void test3() {
        ShortestDistanceFromAllBuildings shortestDistanceFromAllBuildings = new ShortestDistanceFromAllBuildings();
        int[][] grid = {
                {1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 1}, {0, 1, 1, 0, 0, 1}, {1, 0, 0, 1, 0, 1}, {1, 0, 1, 0, 0, 1}, {1, 0, 0, 0, 0, 1}, {0, 1, 1, 1, 1, 0}
        };
        assertEquals(88, shortestDistanceFromAllBuildings.shortestDistance(grid));
    }
}