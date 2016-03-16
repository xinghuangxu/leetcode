package other;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by k586j642 on 3/10/2016.
 */
public class DutchNationalFlagProblemTest extends TestCase {
    @Test
    public void test1() {
        int[] input = new int[]{0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        int[] expected = new int[]{0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2};
        DutchNationalFlagProblem dutchNationalFlagProblem = new DutchNationalFlagProblem();
        dutchNationalFlagProblem.segregate0and1(input);
        assertArrayEquals(input,expected);
    }
}