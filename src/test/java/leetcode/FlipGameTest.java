package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

/**
 * Created by k586j642 on 5/9/2016.
 */
public class FlipGameTest extends TestCase {
    @Test
    public void test1(){
        FlipGame flipGame = new FlipGame();
        List<String> result = flipGame.generatePossibleNextMoves("++++");
        assertEquals(3,result.size());
    }
}