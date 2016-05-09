package datamining;

/**
 * Created by k586j642 on 4/18/2016.
 */
public class HITS {
    public void hits(double[][] l) {
        int length = l.length;
        double[] h = new double[length];
        double[] a = new double[length];
        for (int i = 0; i < length; i++) {
            h[i] = 1;
        }
        double[][] ltran = createTranspose(l);
        for (int k = 0; k < 100; k++) {
            a = multiply(ltran, h);
            h = multiply(l, a);
        }
    }

    private double[] multiply(double[][] ltran, double[] h) {
        double[] result = new double[ltran.length];
        for (int i = 0; i < ltran.length; i++) {
            for (int j = 0; j < ltran[0].length; j++) {
                result[i] += ltran[i][j] * h[j];
            }
        }
        double max = Integer.MIN_VALUE;
        for (int i = 0; i < ltran.length; i++) {
            if (result[i] > max) {
                max = result[i];
            }
        }
        for (int i = 0; i < ltran.length; i++) {
            result[i] = result[i] / max;
        }
        return result;
    }

    private double[][] createTranspose(double[][] l) {
        double[][] ltran = new double[l[0].length][l.length];
        for (int i = 0; i < l.length; i++) {
            for (int j = 0; j < l[0].length; j++) {
                ltran[j][i] = l[i][j];
            }
        }
        return ltran;
    }
}
