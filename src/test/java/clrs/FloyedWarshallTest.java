package clrs;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Xinghuang Leon Xu on 10/28/2015.
 */
public class FloyedWarshallTest extends TestCase {

    @Test
    public void test1() {

        FloyedWarshall floyedWarshall = new FloyedWarshall();
        int m = 100000;
        int[][] dist ={
                {0,m,6,3,m},
                {3,0,m,m,m},
                {m,m,0,2,m},
                {m,1,1,0,m},
                {m,4,m,2,0}
        };
        floyedWarshall.floyedWarshallAlgorithm(dist);
    }
}