package clrs;

/**
 * Created by Xinghuang Leon Xu on 10/28/2015.
 */
public class FloyedWarshall {
    public void floyedWarshallAlgorithm(int[][] dist) {
        int n = dist.length;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];

                    }
                }
            }
            printMatrix(dist);
        }
    }

    private void printMatrix(int[][] dist) {
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist.length; j++) {
                System.out.print(dist[i][j]+",");
            }
            System.out.println();
        }
        System.out.println();
    }
}
