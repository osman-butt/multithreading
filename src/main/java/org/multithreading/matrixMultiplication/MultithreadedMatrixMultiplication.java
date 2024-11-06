package org.multithreading.matrixMultiplication;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MultithreadedMatrixMultiplication extends MatrixMultiplication{

    // TODO: Implement different strategies for parallelizing, ie. which task should be executed
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
        int nThreads = 4;
        ExecutorService executor = Executors.newFixedThreadPool(nThreads);
        System.out.println("Using " + nThreads + " threads");
        List<Future<Void>> futures = new ArrayList<>();

        // Submit tasks for each element of the resulting matrix
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                final int row = i;
                final int col = j;

                // Create a task to calculate each element of the result matrix
                Callable<Void> task = () -> {
                    C[row][col] = getResultForEachElement(row, col, A, B);
                    return null;
                };
                // Submit the task to the executor
                // Each element is calculated in a separate thread
                Future<Void> future = executor.submit(task);

                futures.add(future);
            }
        }

        // Wait for all tasks to complete
        for (Future<Void> future : futures) {
            future.get();
        }

        executor.shutdown();
        return C;
    }

    public int getResultForEachElement(int i, int j, int[][] A, int[][] B) {
        int sum = 0;
        for (int k = 0; k < A[0].length; k++) {
            sum += A[i][k] * B[k][j];
        }
        return sum;
    }
}
