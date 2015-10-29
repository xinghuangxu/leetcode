package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by Xinghuang Leon Xu on 10/26/2015.
 */
public class NimGameTest extends TestCase {
    @Test
    public void test1() {
        NimGame nimGame = new NimGame();
        assertEquals(false, nimGame.canWinNim(4));
    }

    @Test
    public void test2() {
        NimGame nimGame = new NimGame();
        assertEquals(true, nimGame.canWinNim(34));
    }


    @Test
    public void test3() {
        NimGame nimGame = new NimGame();
        assertEquals(true, nimGame.canWinNim(1348820612));
    }
}