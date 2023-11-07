package array;

public class MatrixZeroes {

    public static void helperToSetMinusOne(int row, int col, int m, int n, int[][] matrix) {
        for (int i = 0; i < m; i++) {
            if (matrix[i][col] != 0) {
                matrix[i][col] = -1;
            }
        }

        for (int j = 0; j < n; j++) {
            if (matrix[row][j] != 0) {
                matrix[row][j] = -1;
            }
        }
    }

    // Brute Force Solution
    public static void setZeroes0(int[][] matrix) {
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;

        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < columnLength; col++) {
                if (matrix[row][col] == 0) {
                    helperToSetMinusOne(row, col, rowLength, columnLength, matrix);
                }
            }
        }

        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < columnLength; col++) {
                if (matrix[row][col] == -1) {
                    matrix[row][col] = 0;
                }
            }
        }
    }

    // Optimized Solution
    public static void setZeroes1(int[][] matrix) {
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;
        int firstRow = -1;
        int firstCol = -1;

        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < columnLength; col++) {
                if (matrix[row][col] == 0) {
                    if (row == 0) firstRow = 0;
                    if (col == 0) firstCol = 0;
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                }
            }
        }

        for (int row = 1; row < rowLength; row++) {
            for (int col = 1; col < columnLength; col++) {
                if (matrix[row][0] == 0 || matrix[0][col] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }

        if (firstCol == 0) {
            for (int row = 0; row < rowLength; row++) {
                matrix[row][0] = 0;
            }
        }

        if (firstRow == 0) {
            for (int col = 0; col < columnLength; col++) {
                matrix[0][col] = 0;
            }
        }
    }

    // Optimized Solution
    public static void setZeroes2(int[][] matrix) {
        int col0 = 1, rows = matrix.length, cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) col0 = 0;
            for (int j = 1; j < cols; j++)
                if (matrix[i][j] == 0) matrix[i][0] = matrix[0][j] = 0;
        }

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--)
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            if (col0 == 0) matrix[i][0] = 0;
        }

    }


    public static void main(String[] args) {
        int[][] nums = new int[][]{{3, 1, 2, 0}, {3, 0, 5, 2}, {1, 3, 1, 5}};
        setZeroes0(nums);
        setZeroes1(nums);
        setZeroes2(nums);
    }


}
