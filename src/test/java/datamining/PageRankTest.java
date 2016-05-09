package datamining;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by k586j642 on 4/15/2016.
 */
public class PageRankTest extends TestCase {
    @Test
    public void test1() {
        PageRank pageRank = new PageRank();
        double[][] matrix = {
                {0, 1 / 2.0, 0},
                {1 / 2.0, 0, 1},
                {1 / 2.0, 1 / 2.0, 0}
        };
        pageRank.PageRank(matrix);
    }

    @Test
    public void test2() {
        PageRank pageRank = new PageRank();
        double[][] matrix = {
                {1 / 3.0, 1 / 2.0, 0},
                {1 / 3.0, 0, 1 / 2.0},
                {1 / 3.0, 1 / 2.0, 1 / 2.0}
        };
        pageRank.PageRank(matrix);
    }

    @Test
    public void test3() {
        PageRank pageRank = new PageRank();
        double[][] matrix = {
                {0, 1 / 2.0, 0, 0},
                {1 / 3.0, 0, 0, 1 / 2.0},
                {1 / 3.0, 0, 1, 1 / 2.0},
                {1 / 3.0, 1 / 2.0, 0, 0}
        };

        pageRank.PageRank(matrix);
    }

    @Test
    public void test4() {
        PageRank pageRank = new PageRank();
        double[][] matrix = {
                {1 / 3.0, 1 / 2.0, 0},
                {1 / 3.0, 0, 1 / 2.0},
                {1 / 3.0, 1 / 2.0, 1 / 2.0}
        };

        pageRank.PageRank(matrix);
    }

    @Test
    public void test5() {
        PageRank pageRank = new PageRank();
        double[][] matrix = {
                {1 / 5.0, 1 / 5.0, 1 / 5.0, 1 / 5.0, 0},
                {1 / 5.0, 1 / 5.0, 1 / 5.0, 1 / 5.0, 0},
                {1 / 5.0, 1 / 5.0, 1 / 5.0, 1 / 5.0, 0},
                {1 / 5.0, 1 / 5.0, 1 / 5.0, 1 / 5.0, 0},
                {1 / 5.0, 1 / 5.0, 1 / 5.0, 1 / 5.0, 0}
        };

        pageRank.PageRank(matrix);
    }

    @Test
    public void test6() {
        PageRank pageRank = new PageRank();
        double[][] matrix = {
                {0, 1 / 2.0, 1, 0},
                {1 / 3.0, 0, 0, 1 / 2.0},
                {1 / 3.0, 0, 0, 1 / 2.0},
                {1 / 3.0, 1 / 2.0, 0, 0}
        };
        double[] en = {1, 0, 0, 0};
        pageRank.PageRankTopicSensitive(matrix, en);
    }

    @Test
    public void test7() {
        PageRank pageRank = new PageRank();
        double[][] matrix = {
                {0, 1 / 2.0, 1, 0},
                {1 / 3.0, 0, 0, 1 / 2.0},
                {1 / 3.0, 0, 0, 1 / 2.0},
                {1 / 3.0, 1 / 2.0, 0, 0}
        };
        double[] en = {0, 1 / 2.0, 0, 1 / 2.0};
        pageRank.PageRankTopicSensitive(matrix, en);
    }

    @Test
    public void test8() {
        PageRank pageRank = new PageRank();
        double[][] matrix = {
                {0, 1 / 2.0, 1, 0},
                {1 / 3.0, 0, 0, 1 / 2.0},
                {1 / 3.0, 0, 0, 1 / 2.0},
                {1 / 3.0, 1 / 2.0, 0, 0}
        };
        double[] en = {1 / 2.0, 0, 1 / 2.0, 0};
        pageRank.PageRankTopicSensitive(matrix, en);
    }

    @Test
    public void test9() {
        PageRank pageRank = new PageRank();
        double[][] matrix = {
                {0, 1 / 2.0, 1, 0},
                {1 / 3.0, 0, 0, 1 / 2.0},
                {1 / 3.0, 0, 0, 1 / 2.0},
                {1 / 3.0, 1 / 2.0, 0, 0}
        };
        double[] en = {0, 1, 0, 0};
        pageRank.PageRankTopicSensitive(matrix, en);
    }

    @Test
    public void test10() {
        PageRank pageRank = new PageRank();
        double[][] matrix = {
                {0, 1 / 2.0, 1, 0},
                {1 / 3.0, 0, 0, 1 / 2.0},
                {1 / 3.0, 0, 0, 1 / 2.0},
                {1 / 3.0, 1 / 2.0, 0, 0}
        };
        pageRank.PageRank(matrix);
    }
}