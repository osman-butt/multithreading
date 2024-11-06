package org.multithreading.matrixMultiplication;

import java.util.concurrent.ExecutionException;

public abstract class MatrixMultiplication<T extends Number> {
    public abstract T[][] multiply(T[][] A, T[][] B) throws IllegalArgumentException, ExecutionException, InterruptedException;

}
