package binarySearch;

public class BinarySearch {

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return -1;
    }

    public static int searchRecursive(int[] nums, int target, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;
        if (target == nums[mid]) {
            return mid;
        }

        if (target > nums[mid]) {
            return searchRecursive(nums, target, mid + 1, high);
        } else {
            return searchRecursive(nums, target, mid - 1, high);
        }
    }

    public static int searchOptimized(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (target < nums[mid]) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return nums[lo] == target ? lo : -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 5, 6};
        System.out.println(search(nums, 1));
        System.out.println(searchRecursive(nums, 6, 0, nums.length - 1));
        System.out.println(searchOptimized(nums, 3));
    }


}
