package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Xinghuang Leon Xu on 10/30/2015.
 */
public class PerfectSquaresTest extends TestCase {
    @Test
    public void test1() {
        PerfectSquares perfectSquares = new PerfectSquares();
        assertEquals(3, perfectSquares.numSquares(12));
        assertEquals(2, perfectSquares.numSquares(13));
    }

}