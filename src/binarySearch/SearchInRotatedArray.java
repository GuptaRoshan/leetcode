package binarySearch;

public class SearchInRotatedArray {
    static public int smallestElementBinarySearch(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= nums[high]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    static public int searchUsingRotationPoint(int[] nums, int target) {
        int rot = smallestElementBinarySearch(nums);
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int realMid = (mid + rot) % nums.length;

            if (nums[realMid] == target) return realMid;

            if (nums[realMid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;

    }

    // Intuitive solution
    static public int search(int[] nums, int target) {
        int rot = smallestElementBinarySearch(nums);
        int low = 0;
        int high = nums.length - 1;

        if (nums[rot] <= target && nums[high] >= target) {
            low = rot;
        } else {
            high = rot - 1;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;

            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(smallestElementBinarySearch(nums));
        System.out.println(search(nums, 2));
    }
}
