package binarySearch;

public class SearchMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m * n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (matrix[mid / n][mid % n] == target) {
                return true;
            }
            if (matrix[mid / n][mid % n] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }


    public static boolean searchMatrix2(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            }
            if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int[][] matrix2 = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target = 90;
        System.out.println(searchMatrix(matrix, target));
        System.out.println(searchMatrix2(matrix2, target));
    }

}
