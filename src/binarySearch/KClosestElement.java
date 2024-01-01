package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class KClosestElement {

    public static List<Integer> findClosestElements_TwoPointers(int[] arr, int k, int x) {
        int i = 0, j = arr.length - 1;
        while ((j - i) >= k) {
            if (x - arr[i] <= arr[j] - x) {
                j--;
            } else {
                i++;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int v = i; v <= j; v++) {
            result.add(arr[v]);
        }

        return result;
    }

    public static List<Integer> findClosestElements_BS(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length - k;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (x - arr[mid] < arr[mid + k] - x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return Arrays.stream(arr, low, low + k).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(findClosestElements_BS(nums, 4, 3));
    }
}
