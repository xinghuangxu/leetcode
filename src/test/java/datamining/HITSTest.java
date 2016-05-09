package datamining;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by k586j642 on 4/18/2016.
 */
public class HITSTest extends TestCase {
    @Test
    public void test1() {
        HITS hits = new HITS();
        double[][] matrix = {
                {0, 1, 1, 1, 0},
                {1, 0, 0, 1, 0},
                {0, 0, 0, 0, 1},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0}
        };
        hits.hits(matrix);
    }

    @Test
    public void test2() {
        HITS hits = new HITS();
        double[][] matrix = {
                {0, 1, 1, 1, 0},
                {1, 0, 0, 1, 0},
                {0, 0, 0, 0, 1},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0}
        };
        hits.hits(matrix);
    }
}