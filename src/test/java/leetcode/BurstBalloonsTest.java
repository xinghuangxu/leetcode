package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by xinghuangxu on 3/30/16.
 */
public class BurstBalloonsTest extends TestCase {

    @Test
    public void test1() {
        BurstBalloons burstBalloons = new BurstBalloons();
        int[] nums = {3, 1, 5, 8};
        int actual = burstBalloons.maxCoins(nums);
        int expected = 167;
        assertEquals(expected, actual);
    }

}