package array;

public class RotateMatrix {

    //Brute force solution with new array
    public static int[][] rotate0(int[][] arr) {
        int[][] rotatedArray = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                rotatedArray[j][arr.length - i - 1] = arr[i][j];
            }
        }
        return rotatedArray;
    }


    public static void rotate1(int[][] arr) {

        // Transpose the matrix

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr[0].length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        // Flip the matrix horizontally for clockwise rotation

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length / 2; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[i][arr.length - j - 1];
                arr[i][arr.length - 1 - j] = temp;
            }
        }



        /*

       // Flip the matrix vertically for anti-clockwise rotation

        for (int col = 0; col < arr[0].length; col++) {
            for (int row = 0; row < arr.length / 2; row++) {
                int temp = arr[row][col];
                arr[row][col] = arr[arr.length - row - 1][col];
                arr[arr.length - row - 1][col] = temp;
            }
        }

        */

    }

    public static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        //print(rotate0(arr));
        rotate1(arr);
        print(arr);
    }

}
