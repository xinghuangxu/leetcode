package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by k586j642 on 4/18/2016.
 */
public class UniquePathsTest extends TestCase {
    @Test
    public void test1(){
        UniquePaths uniquePaths = new UniquePaths();
        assertEquals(28,uniquePaths.uniquePaths(3,7));
    }
}