package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by k586j642 on 2/25/2016.
 */
public class SelfCrossingTest extends TestCase {
    @Test
    public void test1() {
        SelfCrossing selfCrossing = new SelfCrossing();
        int[] x = {2,1,1,2};
        assertTrue(selfCrossing.isSelfCrossing(x));
    }

    @Test
    public void test2() {
        SelfCrossing selfCrossing = new SelfCrossing();
        int[] x = {1,2,3,4};
        assertFalse(selfCrossing.isSelfCrossing(x));
    }

    @Test
    public void test3() {
        SelfCrossing selfCrossing = new SelfCrossing();
        int[] x = {1,1,1,1};
        assertTrue(selfCrossing.isSelfCrossing(x));
    }

    @Test
    public void test4() {
        SelfCrossing selfCrossing = new SelfCrossing();
        int[] x = {1,1,2,2,3,3,4,4,10,4,4,3,3,2,2,1,1};
        assertFalse(selfCrossing.isSelfCrossing(x));
    }
}