import org.junit.jupiter.api.Test;
import org.multithreading.matrixMultiplication.MatrixMultiplication;
import org.multithreading.matrixMultiplication.SingleThreadedMatrixMultiplication;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class SingleMatrixMultiplicationTest {

    @Test
    void testMultiplyMatrices() throws ExecutionException, InterruptedException {
        // Arrange
        int[][] A = { {1, 2}, {3, 4} };
        int[][] B = { {5, 6}, {7, 8} };
        int[][] expected = { {19, 22}, {43, 50} };

        MatrixMultiplication multiplication = new SingleThreadedMatrixMultiplication();

        // Act
        int[][] result = multiplication.multiply(A, B);

        // Assert
        assertArrayEquals(expected, result, "The matrix multiplication result is incorrect.");
    }

    @Test
    void testMultiplyMatricesWithDifferentDimensions() {
        // Arrange
        int[][] A = { {1, 2}, {3, 4} };
        int[][] B = { {5, 6} };
        MatrixMultiplication multiplication = new SingleThreadedMatrixMultiplication();

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> multiplication.multiply(A, B));
    }

    @Test
    void testMultiplyMatricesWithDifferentDimensions2() {
        // Arrange
        int[][] A = { {1, 2}, {3, 4} };
        int[][] B = { {5, 6}, {7, 8}, {9, 10} };
        MatrixMultiplication multiplication = new SingleThreadedMatrixMultiplication();

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> multiplication.multiply(A, B));
    }
}
