package array.twoPointers;

public class maxSubArrayProduct {

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int p = 1;
        int count = 0;

        while (end < nums.length) {
            p = p * nums[end];
            while (start < nums.length && p >= k) {
                p = p / nums[start];
                start++;
            }
            if (p < k) {
                count = count + (end - start + 1);
            }
            end++;
        }
        return count;
    }

    public static int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);

            if (max > ans) {
                ans = max;
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        int target = 1;
        System.out.println(numSubarrayProductLessThanK(nums, target));
    }
}
