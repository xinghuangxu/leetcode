package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xinghuangxu on 8/18/15.
 */
public class CourseScheduleTest {
    @Test
    public void test1() {

        int[][] prerequisite = {
                { 1, 0 }
        };
        CourseSchedule courseSchedule = new CourseSchedule();
        boolean actual = courseSchedule.canFinish(2, prerequisite);
        assertEquals(true, actual);
    }

    @Test
    public void test2() {

        int[][] prerequisite = {
                { 1, 0 },
                { 0, 1 }
        };
        CourseSchedule courseSchedule = new CourseSchedule();
        boolean actual = courseSchedule.canFinish(2, prerequisite);
        assertEquals(false, actual);
    }

    @Test
    public void test3() {

        int[][] prerequisite = {
                {}
        };
        CourseSchedule courseSchedule = new CourseSchedule();
        boolean actual = courseSchedule.canFinish(1, prerequisite);
        assertEquals(true, actual);
    }

    @Test
    public void test4() {

        int[][] prerequisite = {
                {2,0},
                {2,1}
        };
        CourseSchedule courseSchedule = new CourseSchedule();
        boolean actual = courseSchedule.canFinish(3, prerequisite);
        assertEquals(true, actual);
    }

    @Test
    public void test5() {

        int[][] prerequisite = {
                {0,1},{3,1},{1,3},{3,2}
        };
        CourseSchedule courseSchedule = new CourseSchedule();
        boolean actual = courseSchedule.canFinish(4, prerequisite);
        assertEquals(false, actual);
    }

    @Test
    public void test6() {
        int[][] prerequisite = {
                {0,1},{0,2},{1,2}
                //3, [[0,1],[0,2],[1,2]]
        };
        CourseSchedule courseSchedule = new CourseSchedule();
        boolean actual = courseSchedule.canFinish(3, prerequisite);
        assertEquals(true, actual);
    }

    @Test
    public void test7() {
        int[][] prerequisite = {
                {1,0},{2,6},{1,7},{5,1},{6,4},{7,0},{0,5},{5,1},{6,4}
                //8, [[1,0],[2,6],[1,7],[5,1],[6,4],[7,0],[0,5],[5,1],[6,4]]
        };
        CourseSchedule courseSchedule = new CourseSchedule();
        boolean actual = courseSchedule.canFinish(8, prerequisite);
        assertEquals(false, actual);
    }
}