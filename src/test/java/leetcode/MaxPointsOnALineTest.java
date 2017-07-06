package leetcode;

import helper.Point;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by xinghuangxu on 4/19/16.
 */
public class MaxPointsOnALineTest extends TestCase {

    @Test
    public void test1() {
        Point p = new Point(0, 0);
        Point[] points = {p};
        MaxPointsOnALine maxPointsOnALine = new MaxPointsOnALine();
        assertEquals(1, maxPointsOnALine.maxPoints(points));
    }

    //[[2,3],[3,3],[-5,3]]
    @Test
    public void test2() {
        Point p1 = new Point(2, 3);
        Point p2 = new Point(3, 3);
        Point p3 = new Point(-5, 3);
        Point[] points = {p1, p2, p3};
        MaxPointsOnALine maxPointsOnALine = new MaxPointsOnALine();
        assertEquals(3, maxPointsOnALine.maxPoints(points));
    }

    @Test
    public void test3() {
        Point p1 = new Point(4, 0);
        Point p2 = new Point(4, -1);
        Point p3 = new Point(4, 5);
        Point[] points = {p1, p2, p3};
        MaxPointsOnALine maxPointsOnALine = new MaxPointsOnALine();
        assertEquals(3, maxPointsOnALine.maxPoints(points));
    }

    @Test
    public void test4() {
        Point p1 = new Point(4, -1);
        Point p2 = new Point(4, -1);
        Point p3 = new Point(4, 5);
        Point[] points = {p1, p2, p3};
        MaxPointsOnALine maxPointsOnALine = new MaxPointsOnALine();
        assertEquals(3, maxPointsOnALine.maxPoints(points));
    }

    //[[0,0],[1,1],[1,-1]]
    @Test
    public void test5() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, -1);
        Point p3 = new Point(1, 1);
        Point[] points = {p1, p2, p3};
        MaxPointsOnALine maxPointsOnALine = new MaxPointsOnALine();
        assertEquals(2, maxPointsOnALine.maxPoints(points));
    }

    //[[-4,1],[-7,7],[-1,5],[9,-25]]
    @Test
    public void test6() {
        Point p1 = new Point(-4, 1);
        Point p2 = new Point(-7, 7);
        Point p3 = new Point(-1, 5);
        Point p4 = new Point(9, -25);
        Point[] points = {p1, p2, p3, p4};
        MaxPointsOnALine maxPointsOnALine = new MaxPointsOnALine();
        assertEquals(3, maxPointsOnALine.maxPoints(points));
    }

    //[[0,-12],[5,2],[2,5],[0,-5],[1,5],[2,-2],[5,-4],[3,4],[-2,4],[-1,4],[0,-5],[0,-8],[-2,-1],[0,-11],[0,-9]]
    @Test
    public void test7() {
        Point p1 = new Point(0, -12);
        Point p2 = new Point(5, 2);
        Point p3 = new Point(2, 5);
        Point p4 = new Point(0, -5);

        Point p5 = new Point(1, 5);
        Point p6 = new Point(2, -2);
        Point p7 = new Point(5, -4);
        Point p8 = new Point(3, 4);

        Point p9 = new Point(-2, 4);
        Point p10 = new Point(-1, 4);
        Point p11 = new Point(0, -5);
        Point p12 = new Point(0, -8);

        Point p13 = new Point(-2, -1);
        Point p14 = new Point(0, -11);
        Point p15 = new Point(0, -9);
        Point[] points = {p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15};
        MaxPointsOnALine maxPointsOnALine = new MaxPointsOnALine();
        assertEquals(6, maxPointsOnALine.maxPoints(points));
    }
}