package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by Xinghuang Leon Xu on 9/1/2015.
 */
public class BasicCalculatorIITest extends TestCase {

    @Test
    public void test1() {
        BasicCalculatorII basicCalculator = new BasicCalculatorII();
        int actual = basicCalculator.calculate("3+2*2");
        assertEquals(7, actual);
    }

    @Test
    public void test2() {
        BasicCalculatorII basicCalculator = new BasicCalculatorII();
        int actual = basicCalculator.calculate(" 3/2 ");
        assertEquals(1, actual);
    }

    @Test
    public void test3() {
        BasicCalculatorII basicCalculator = new BasicCalculatorII();
        int actual = basicCalculator.calculate(" 3+5 / 2 ");
        assertEquals(5, actual);
    }

    @Test
    public void test4() {
        BasicCalculatorII basicCalculator = new BasicCalculatorII();
        int actual = basicCalculator.calculate(" 3+15 / 2 ");
        assertEquals(10, actual);
    }

    @Test
    public void test5() {
        BasicCalculatorII basicCalculator = new BasicCalculatorII();
        int actual = basicCalculator.calculate(" 42 ");
        assertEquals(10, actual);
    }
}