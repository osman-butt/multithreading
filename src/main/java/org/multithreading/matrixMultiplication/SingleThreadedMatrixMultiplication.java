package org.multithreading.matrixMultiplication;

import java.util.concurrent.ExecutionException;

public class SingleThreadedMatrixMultiplication extends MatrixMultiplication{

    @Override
    public int[][] multiply(int[][] A, int[][] B) throws IllegalArgumentException, ExecutionException, InterruptedException {
        int rowsA = A.length;
        int colsA = A[0].length;
        int rowsB = B.length;
        int colsB = B[0].length;

        if (colsA != rowsB) {
            throw new IllegalArgumentException("Matrix dimensions are incompatible for multiplication");
        }

        int[][] C = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }

}
