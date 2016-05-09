package datamining;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by k586j642 on 4/15/2016.
 */
public class PageRank {
    void PageRank(double[][] matrix) {
        int row = matrix.length;
        int coloum = matrix[0].length;
        double[] v0 = new double[row];
        double[] en = new double[row];
        for (int i = 0; i < coloum; i++) {
            v0[i] = 1 / (double) coloum;
            en[i] = v0[i];
        }
        List<double[]> result = new ArrayList();
        result.add(v0);
        double beta = 0.8;
        for (int k = 0; k < 100; k++) {
            double[] v1 = new double[row];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < coloum; j++) {
                    v1[i] += v0[j] * matrix[i][j];
                }
                v1[i] = beta * v1[i] + (1 - beta) * en[i];
            }
            v0 = v1;
            result.add(v1);
        }
    }

    public void PageRankTopicSensitive(double[][] matrix, double[] en) {
        int row = matrix.length;
        int coloum = matrix[0].length;
        double[] v0 = new double[row];
        for (int i = 0; i < coloum; i++) {
            v0[i] = en[i];
        }
        List<double[]> result = new ArrayList();
        result.add(v0);
        double beta = 0.8;
        for (int k = 0; k < 100; k++) {
            double[] v1 = new double[row];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < coloum; j++) {
                    v1[i] += v0[j] * matrix[i][j];
                }
                v1[i] = beta * v1[i] + (1 - beta) * en[i];
            }
            v0 = v1;
            result.add(v1);
        }
    }
}
