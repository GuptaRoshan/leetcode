package array;

public class SquaresSortedArray {
    public static int[] sortedSquares(int[] nums) {

        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int k = right;

        while (left <= right) {
            int val = 0;

            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                val = Math.abs(nums[left]);
                left++;
            } else {
                val = Math.abs(nums[right]);
                right--;
            }

            result[k] = val * val;
            k--;
        }

        return result;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{-7, -3, 2, 3, 11};
        int target = 17;
        System.out.println(sortedSquares(nums));
    }
}
