package recursion;

public class Print2DArray {
    public static void printArray(int[][] arr, int row, int col) {
        // Base case: Reached end of array
        if (row >= arr.length || col >= arr[0].length) {
            return;
        }

        // Print current element and move to next column
        System.out.print(arr[row][col] + " ");
        printArray(arr, row, col + 1);

        // After printing the row, move to the next row (if not at the last row)
        if (col == arr[0].length - 1) {
            System.out.println();  // Print a new line for the next row
            printArray(arr, row + 1, 0);
        }
    }

    public static void main(String[] args) {
        int[][] myArray = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("Printing 2D array recursively:");
        printArray(myArray, 0, 0);
    }
}
