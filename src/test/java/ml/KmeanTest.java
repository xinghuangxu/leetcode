package ml;

import helper.WordDictionary;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by xinghuangxu on 11/21/15.
 */
public class KmeanTest extends TestCase {
    @Test
    public void test1() {
        Kmean kmean = new Kmean();
        List<Point2D> dataList = new ArrayList();
        List<Point2D> centroids = new ArrayList();

        dataList.add(new Point2D(1.9, 0.97));
        dataList.add(new Point2D(1.76, 0.84));
        dataList.add(new Point2D(2.32, 1.63));
        dataList.add(new Point2D(2.31, 2.09));
        dataList.add(new Point2D(1.14, 2.11));
        dataList.add(new Point2D(5.02, 3.02));
        dataList.add(new Point2D(5.74, 3.84));
        dataList.add(new Point2D(2.25, 3.47));
        dataList.add(new Point2D(4.71, 3.6));
        dataList.add(new Point2D(3.17, 4.96));

        centroids.add(new Point2D(5.74, 3.84));
        centroids.add(new Point2D(2.25, 3.47));
        kmean.kmean(dataList, centroids);
    }
}