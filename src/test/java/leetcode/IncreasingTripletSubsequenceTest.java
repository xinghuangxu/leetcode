package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by k586j642 on 2/26/2016.
 */
public class IncreasingTripletSubsequenceTest extends TestCase {

    @Test
    public void test1() {
        IncreasingTripletSubsequence increasingTripletSubsequence = new IncreasingTripletSubsequence();
        int[] nums = {1, 2, 3, 4, 5};
        assertTrue(increasingTripletSubsequence.increasingTriplet(nums));
    }

    @Test
    public void test2() {
        IncreasingTripletSubsequence increasingTripletSubsequence = new IncreasingTripletSubsequence();
        int[] nums = {5, 4, 3, 2, 1};
        assertFalse(increasingTripletSubsequence.increasingTriplet(nums));
    }

    @Test
    public void test3() {
        IncreasingTripletSubsequence increasingTripletSubsequence = new IncreasingTripletSubsequence();
        int[] nums = {1,2,1,2,1,2,1,2,1,2};
        assertFalse(increasingTripletSubsequence.increasingTriplet(nums));
    }

    @Test
    public void test4() {
        IncreasingTripletSubsequence increasingTripletSubsequence = new IncreasingTripletSubsequence();
        int[] nums = {4,10,1,8,9};
        assertTrue(increasingTripletSubsequence.increasingTriplet(nums));
    }

    @Test
    public void test5() {
        IncreasingTripletSubsequence increasingTripletSubsequence = new IncreasingTripletSubsequence();
        int[] nums = {11,10,14,4,15,12};
        assertTrue(increasingTripletSubsequence.increasingTriplet(nums));
    }
}