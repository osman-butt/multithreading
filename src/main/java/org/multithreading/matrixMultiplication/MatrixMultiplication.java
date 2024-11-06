package org.multithreading.matrixMultiplication;

import java.util.concurrent.ExecutionException;

public abstract class MatrixMultiplication {
    public abstract int[][] multiply(int[][] A, int[][] B) throws IllegalArgumentException, ExecutionException, InterruptedException;

}
