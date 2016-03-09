package leetcode;

import junit.framework.TestCase;
import junit.framework.TestResult;
import org.junit.Test;

/**
 * Created by k586j642 on 3/9/2016.
 */
public class PowerOfThreeTest extends TestCase {
    @Test
    public void test1() {
        PowerOfThree powerOfThree = new PowerOfThree();
        assertFalse(powerOfThree.isPowerOfThree(0));
        assertTrue(powerOfThree.isPowerOfThree(9));
    }
}