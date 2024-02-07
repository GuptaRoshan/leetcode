package array;

public class MatrixZeroes {

    // Optimized Solution
    public static void setZeroes(int[][] matrix) {
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;
        int firstRow = -1;
        int firstCol = -1;

        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < columnLength; col++) {
                if (matrix[row][col] == 0) {
                    if (row == 0) firstRow = 0; // cell (0, 0) is common point for the row and column
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

        // Set zero in first row
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


    public static void main(String[] args) {
        int[][] nums = new int[][]{{3, 1, 2, 0}, {3, 0, 5, 2}, {1, 3, 1, 5}};
        setZeroes(nums);
    }


}
