package array;

public class PositiveInteger {
    public static int positiveInteger(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {

            /**
             For example, if nums[i] is 3, we expect 3 to be at index 2 (3 - 1 = 2).
             The expression nums[nums[i] - 1] != nums[i] checks whether the current number nums[i] is at its correct position in the array.
             If it is not (meaning the value at index nums[i] - 1 is not the same as nums[i]),
             it implies that we need to swap the current number with the number at its correct position.
             **/
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap the current number to its correct position
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2, 0}; // [1, 2, 0]
        int[] num2 = new int[]{3, 4, -1, 2}; // [-1, 2,  3, 4]
        int[] num3 = new int[]{7, 8, 9, 11, 12}; // [7, 8, 9, 12]
        System.out.println(positiveInteger(num1));
        System.out.println(positiveInteger(num2));
        System.out.println(positiveInteger(num3));
    }
}
