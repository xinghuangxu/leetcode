package leetcode;

import junit.framework.TestCase;
import org.junit.Test;


/**
 * Created by xinghuangxu on 10/27/15.
 */
public class RectangleAreaTest extends TestCase {
    @Test
    public void test1() {
        RectangleArea rectangleArea = new RectangleArea();
        assertEquals(24 + 27 - 6, rectangleArea.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }

    @Test
    public void test2() {
        RectangleArea rectangleArea = new RectangleArea();
        assertEquals(17, rectangleArea.computeArea(-2, -2, 2, 2, 3, 3, 4, 4));
    }

    @Test
    public void test3() {
        RectangleArea rectangleArea = new RectangleArea();
        assertEquals(17, rectangleArea.computeArea(-1500000001, 0, -1500000000, 1500000000, 0, 1500000001, 4, 4));
    }
}