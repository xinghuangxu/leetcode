package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Xinghuang Leon Xu on 10/29/2015.
 */
public class FirstBadVersionTest extends TestCase {
    @Test
    public void test() {
        FirstBadVersion firstBadVersion = new FirstBadVersion();
        assertEquals(2, firstBadVersion.firstBadVersion(2126753390));
    }

}