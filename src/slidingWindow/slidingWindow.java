package slidingWindow;

public class slidingWindow {

    public static int maxSumFixedSize(int[] arr, int k) {
        int n = arr.length;

        // Compute sum of first window of size k
        int max_sum = 0;
        for (int i = 0; i < k; i++)
            max_sum += arr[i];


        int window_sum = max_sum;
        for (int i = k; i < n; i++) {
            window_sum = (window_sum + arr[i]) - arr[i - k];
            max_sum = Math.max(max_sum, window_sum);
        }

        return max_sum;
    }

    public static int longestSubarrayVariableSize(int[] arr, int target) {
        int left = 0;
        int right = 0;
        int currentSum = 0;
        int maxLength = 0;

        while (right < arr.length) {
            currentSum += arr[right];

            while (currentSum > target) {
                currentSum = currentSum - arr[left];
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 4, 1, 2, 1, 5, 3};
        int windowSize = 4;
        System.out.println(maxSumFixedSize(arr, windowSize));
        System.out.println(longestSubarrayVariableSize(arr, 7));
    }
}
