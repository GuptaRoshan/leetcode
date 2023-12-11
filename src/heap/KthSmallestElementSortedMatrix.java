package heap;

public class KthSmallestElementSortedMatrix {

    int m, n = 0;

    public int countLessOrEqual(int[][] matrix, int k) {
        int col = n - 1;
        int count = 0;

        for (int row = 0; row < m; row++) {
            while (col >= 0 && matrix[row][col] > k) {
                col--;
            }
            count = count + (col + 1);
        }

        return count;
    }


    public int kthSmallest(int[][] matrix, int k) {
        m = matrix.length;
        n = matrix[0].length;

        int low = matrix[0][0];
        int high = matrix[m - 1][n - 1];
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = countLessOrEqual(matrix, k);

            if (count >= k) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int k = 8;

        KthSmallestElementSortedMatrix obj = new KthSmallestElementSortedMatrix();
        System.out.println(obj.kthSmallest(matrix, k));
    }

}
