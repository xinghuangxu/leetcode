package ml;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xinghuangxu on 11/21/15.
 */
public class Kmean {

    public void kmean(List<Point2D> dataList, List<Point2D> centroids) {
        int iteration = 0;
        while(iteration<2){
            int k = centroids.size();
            List[] clusters = new List[k];
            for (int i = 0; i < k; i++) {
                clusters[i] = new ArrayList();
            }
            for (int i = 0; i < dataList.size(); i++) {
                Point2D cur = dataList.get(i);
                int minJ = 0;
                double distance = Double.MAX_VALUE;
                for (int j = 0; j < k; j++) {
                    double curDistance = Math.sqrt(Math.pow(centroids.get(j).x - cur.x, 2) + Math.pow(centroids.get(j).y - cur.y, 2));
                    if (curDistance < distance) {
                        minJ = j;
                    }
                }
                clusters[minJ].add(cur);
            }
            centroids = new ArrayList<Point2D>();
            for (int i = 0; i < k; i++) {
                List<Point2D> list = clusters[k];
                Point2D nCentroids = new Point2D(0, 0);
                for (Point2D p : list) {
                    nCentroids.x = p.x + nCentroids.x;
                    nCentroids.y = p.y + nCentroids.y;
                }
                nCentroids.x = nCentroids.x / list.size();
                nCentroids.y = nCentroids.y / list.size();
                centroids.add(nCentroids);
            }
            iteration++;
        }
    }

}
