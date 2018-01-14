import java.util.Arrays;

public class MatrixMultiplication {
    public static void main(String args[]) {
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        int[][] matrix2 = {{1, 2}, {3, 4}, {5, 6}};
        int[][] arr = matrixMultiplication(matrix1, matrix2);
        System.out.println(Arrays.deepToString(arr));
    }

    private static int[][] matrixMultiplication(int[][] matrix1, int[][] matrix2)
    {
        int[][] resultMatrix = new int[matrix1.length][matrix2[0].length];
        for(int i = 0; i < matrix1.length; i++) {
            for(int j = 0; j < matrix2[0].length; j++) {
                for(int k = 0; k < matrix2.length; k++) {
                    resultMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return resultMatrix;
    }
}
