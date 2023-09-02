package array;

public class RotateMatrix {

    public static int[][] rotate(int[][] arr) {
        int[][] rotatedArray = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                rotatedArray[j][arr.length - i - 1] = arr[i][j];
            }
        }
        return rotatedArray;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] rotatedArr = rotate(arr);

        for (int i = 0; i < rotatedArr.length; i++) {
            for (int j = 0; j < rotatedArr.length; j++) {
                System.out.print(rotatedArr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
