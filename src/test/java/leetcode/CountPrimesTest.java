package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Xinghuang Leon Xu on 10/29/2015.
 */
public class CountPrimesTest extends TestCase {
    @Test
    public void test1() {

        CountPrimes countPrimes = new CountPrimes();
        assertEquals(4,countPrimes.countPrimes(10));
    }
    @Test
    public void test2() {

        CountPrimes countPrimes = new CountPrimes();
        assertEquals(4, countPrimes.countPrimes(11));
    }
}