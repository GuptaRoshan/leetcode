package array.slidingWindow;

public class MaxAverageSubArray {

    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum = sum + nums[i];
        }

        int maxSum = sum;

        for (int j = k; j < nums.length; j++) {
            maxSum = maxSum + nums[j] - nums[j - k];
            sum = Math.max(sum, maxSum);
        }

        return Double.valueOf(sum) / k;
    }

    public static void main(String[] args) {
        int[] num = new int[]{1, 12, -5, -6, 50, 3};
        System.out.println(findMaxAverage(num, 4));
    }

}
