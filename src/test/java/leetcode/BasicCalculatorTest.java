package leetcode;

import helper.TreeNode;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

/**
 * Created by Xinghuang Leon Xu on 8/31/2015.
 */
public class BasicCalculatorTest extends TestCase {
    @Test
    public void test1() {
        BasicCalculator basicCalculator = new BasicCalculator();
        int actual = basicCalculator.calculate("1 + 1");
        assertEquals(2, actual);
    }

    @Test
    public void test2() {
        BasicCalculator basicCalculator = new BasicCalculator();
        int actual = basicCalculator.calculate(" 2-1 + 2 ");
        assertEquals(3, actual);
    }

    @Test
    public void test3() {
        BasicCalculator basicCalculator = new BasicCalculator();
        int actual = basicCalculator.calculate("(1+(4+5+2)-3)+(6+8)");
        assertEquals(23, actual);
    }

    //"2-4-(8+2-6+(8+4-(1)+8-10))"
    @Test
    public void test4() {
        BasicCalculator basicCalculator = new BasicCalculator();
        int actual = basicCalculator.calculate("2-4-(8+2-6+(8+4-(1)+8-10))");
        assertEquals(-15, actual);
    }

    @Test
    public void test5() {
        BasicCalculator basicCalculator = new BasicCalculator();
        int actual = basicCalculator.calculate("4-(1)");
        assertEquals(3, actual);
    }
}