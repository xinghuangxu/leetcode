package leetcode;

import junit.framework.TestCase;
import org.testng.annotations.Test;

import javax.sound.midi.Patch;

/**
 * Created by k586j642 on 2/29/2016.
 */
public class PatchingArrayTest extends TestCase {

    @Test
    public void test1() {
        PatchingArray patchingArray = new PatchingArray();
        int actual = patchingArray.minPatches(new int[]{1, 5, 10}, 20);
        int expected = 2;
        assertEquals(actual, expected);
    }

    @Test
    public void test2() {
        PatchingArray patchingArray = new PatchingArray();
        int actual = patchingArray.minPatches(new int[]{1, 3}, 6);
        int expected = 1;
        assertEquals(actual, expected);
    }

    @Test
    public void test3() {
        PatchingArray patchingArray = new PatchingArray();
        int actual = patchingArray.minPatches(new int[]{1, 2, 2}, 5);
        int expected = 0;
        assertEquals(actual, expected);
    }

    @Test
    public void test4() {
        PatchingArray patchingArray = new PatchingArray();
        int actual = patchingArray.minPatches(new int[]{1,2,31,33}, 2147483646);
        int expected = 0;
        assertEquals(actual, expected);
    }

    @Test
    public void test5() {
        PatchingArray patchingArray = new PatchingArray();
        int actual = patchingArray.minPatches(new int[]{1,2,31,33}, 2147483647);
        int expected = 0;
        assertEquals(actual, expected);
    }

    @Test
    public void test6() {
        PatchingArray patchingArray = new PatchingArray();
        int actual = patchingArray.minPatches(new int[]{1,2,2,3,3, 3}, 1002342);
        int expected = 2;
        assertEquals(actual, expected);
    }
}