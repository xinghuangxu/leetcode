package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by xinghuangxu on 10/27/15.
 */
public class MissingNumberTest extends TestCase {
    @Test
    public void test1() {

        MissingNumber missingNumber = new MissingNumber();
        assertEquals(2, missingNumber.missingNumber(new int[]{0,1,3}));
    }
}