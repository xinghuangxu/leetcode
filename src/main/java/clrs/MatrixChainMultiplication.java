package clrs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Xinghuang Leon Xu on 9/29/2015.
 */
public class MatrixChainMultiplication {

    public int[][] matrixChainMultiplication(int[][] matrix) {
        //print out the optimal combination
        int numMatrix = matrix.length;
        int[][] matrices = new int[numMatrix][numMatrix];
        int[][] breaks = new int[numMatrix][numMatrix];

        for (int i = 1; i < numMatrix; i++) {
            for (int j = 0; j + i < numMatrix; j++) {
                int min = Integer.MAX_VALUE;
                int b = j;
                for (int k = j; k < j + i; k++) {
                    int tmp = matrices[j][k] + matrices[k + 1][j + i] + matrix[j][0] * matrix[k][1] * matrix[j + i][1];
                    if (min > tmp) {
                        min = tmp;
                        b = k;
                    }
                }
                matrices[j][j + i] = min;
                breaks[j][j + i] = b;
            }
        }
        System.out.println(printMatrixChain(breaks, 0, numMatrix - 1));
        for (int i = 0; i < numMatrix; i++) {
            for (int j = 0; j < numMatrix; j++) {
                System.out.print(String.format("%7d", matrices[i][j]));
            }
            System.out.println();
        }
        return matrices;
    }

    public int matrixChainMultiplicationGreedy(int[][] matrix) {

        int numMatrix = matrix.length;
        //Initialize matrices in a list
        List<int[]> matrices = new ArrayList<int[]>();
        for (int i = 0; i < numMatrix; i++) {
            matrices.add(matrix[i]);
        }

        int value = 0;
        while (matrices.size() != 1) {
            //select two adjacent matrices with the smallest multiplication cost
            int minIndex = -1;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j + 1 < matrices.size(); j++) {
                int tmp = matrices.get(j)[0] * matrices.get(j)[1] * matrices.get(j + 1)[1];
                if (tmp < min) {
                    min = tmp;
                    minIndex = j;
                }
            }
            value += min;
            matrices.set(minIndex, new int[]{matrices.get(minIndex)[0], matrices.get(minIndex + 1)[1]});
            matrices.remove(minIndex + 1);
        }
        return value;
    }

    private String printMatrixChain(int[][] breaks, int start, int end) {
        if (start == end) {
            return "A" + (start + 1);
        } else {
            return "(" + printMatrixChain(breaks, start, breaks[start][end]) + printMatrixChain(breaks, breaks[start][end] + 1, end) + ")";
        }
    }

}
