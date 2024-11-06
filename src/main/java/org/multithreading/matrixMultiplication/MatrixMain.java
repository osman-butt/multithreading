package org.multithreading.matrixMultiplication;

import java.util.concurrent.ExecutionException;

public class MatrixMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[][] A = createRandomMatrix(1_000, 1_000);
        int[][] B = createRandomMatrix(1_000, 1_000);

        var singleTimeStart = System.currentTimeMillis();
        MatrixMultiplication singleThreaded = new SingleThreadedMatrixMultiplication();
        System.out.println("Single-threaded Start:");
        int[][] resultSingle = singleThreaded.multiply(A, B);
        System.out.println("Single-threaded time: " + (System.currentTimeMillis() - singleTimeStart));

        // Using MultiThreadedMatrixMultiplication
        var multiTimeStart = System.currentTimeMillis();
        MatrixMultiplication multiThreaded = new MultithreadedMatrixMultiplication();
        System.out.println("Multi-threaded Start:");
        int[][] resultMulti = multiThreaded.multiply(A, B);
        System.out.println("Multi-threaded time: " + (System.currentTimeMillis() - multiTimeStart));

        System.out.println("Sanity check - Are matrices equal? " + areMatricesEqual(resultSingle, resultMulti));

    }

    public static int[][] createRandomMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
            }
        }
        return matrix;
    }

    public static boolean areMatricesEqual(int[][] matrix1, int[][] matrix2) {
        // Check if both matrices have the same number of rows
        if (matrix1.length != matrix2.length) {
            return false;
        }

        // Check if both matrices have the same number of columns
        for (int i = 0; i < matrix1.length; i++) {
            if (matrix1[i].length != matrix2[i].length) {
                return false;
            }
        }

        // Compare corresponding elements of the matrices
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                if (matrix1[i][j] != matrix2[i][j]) {
                    return false;
                }
            }
        }

        // If all checks pass, the matrices are equal
        return true;
    }
}
