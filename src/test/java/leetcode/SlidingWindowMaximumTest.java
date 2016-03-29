package leetcode;

import com.sun.media.sound.SoftLinearResampler;
import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by k586j642 on 3/24/2016.
 */
public class SlidingWindowMaximumTest extends TestCase {

    @Test
    public void test1(){
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] expected = {3,3,5,5,6,7};
        int[] actual = slidingWindowMaximum.maxSlidingWindow(nums,k);
        assertArrayEquals(expected, actual);
    }
}