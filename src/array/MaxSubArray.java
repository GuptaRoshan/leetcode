package array;

public class MaxSubArray {

    public static int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        while (end < nums.length) {
            sum += nums[end];
            while (start <= end && sum >= target) {
                min = Math.min(min, end - start + 1);
                sum = sum - nums[start];
                start++;
            }
            end++;
        }
        return (min == Integer.MAX_VALUE) ? 0 : min;
    }

    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 1, 3, 4, 1, 2, 1, 5, 3};
        System.out.println(minSubArrayLen(target, nums));
    }
}
