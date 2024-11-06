package org.multithreading.matrixMultiplication;

import java.util.concurrent.ExecutionException;

public class MultithreadedMatrixMultiplication<T extends Number> extends MatrixMultiplication<T>{
    @Override
    public T[][] multiply(T[][] A, T[][] B) throws IllegalArgumentException, ExecutionException, InterruptedException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
