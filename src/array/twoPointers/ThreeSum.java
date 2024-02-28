package array.twoPointers;

import java.util.*;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        if (nums.length == 0) {
            return new ArrayList<>(result);
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return new ArrayList<>(result);
    }

    public static int threeSumClosest(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - sum) < Math.abs(target - closest)) {
                    closest = sum;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return closest;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{-1, 0, 1, 2, -1, -4};
        int target = 1;
        System.out.println(threeSum(numbers));
        System.out.println(threeSumClosest(numbers, target));
    }

}
