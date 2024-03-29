package array;

public class MatrixConversion {

    public static void convert2DTo1DMatrix(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int[] oneMatrix = new int[m * n];

        for (int row = 0; row < m; row++)
            for(int col = 0; col < n; col++)
                oneMatrix[row * m + col] = arr[row][col];
    }

    public static void convert1DTo2DMatrix(int[] arr) {
        int m = 2;
        int n = arr.length;

        int[][] twoMatrix = new int[m][m];
        for (int i = 0; i < n; i++) {
            twoMatrix[i / m][i % m] = arr[i];
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {3, 4}};
        convert2DTo1DMatrix(arr);
        int[] arr1 = {1, 2, 3, 4};
        convert1DTo2DMatrix(arr1);
    }
}
