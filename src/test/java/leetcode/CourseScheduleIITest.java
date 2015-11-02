package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by Xinghuang Leon Xu on 11/1/2015.
 */
public class CourseScheduleIITest extends TestCase {
    @Test
    public void test2() {

        int[][] prerequisite = {
                { 1, 0 }
        };
        CourseScheduleII courseSchedule = new CourseScheduleII();
        int[] actual = courseSchedule.findOrder(2, prerequisite);
        assertArrayEquals(new int[]{0,1}, actual);
    }

    @Test
    public void test3() {

        int[][] prerequisite = {

                        {5,8},{3,5},{1,9},{4,5},{0,2},{1,9},{7,8},{4,9}
        };
        CourseScheduleII courseSchedule = new CourseScheduleII();
        int[] actual = courseSchedule.findOrder(10, prerequisite);
        assertArrayEquals(new int[]{0,1}, actual);
    }
}