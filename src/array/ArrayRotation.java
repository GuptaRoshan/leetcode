package array;

public class ArrayRotation {

    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4};
        int k = 1;
        int n = num.length;
        int[] temp = new int[n];
        for (int i = 0; i < num.length; i++) {
            temp[(i + k) % n] = num[i];
        }

        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i]);
        }
    }
}
