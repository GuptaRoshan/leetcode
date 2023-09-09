package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    public static int singleNumberUsingTwoPointers(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i = i + 2) {
            if (nums[i] != nums[i - 1]) {
                return nums[i - 1];
            }
        }
        return nums[nums.length - 1];
    }

    public static int singleNumberUsingHashMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
            if (it.getValue() == 1) {
                return it.getKey();
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 4, 4};
        System.out.println(singleNumberUsingTwoPointers(nums));
        System.out.println(singleNumberUsingHashMap(nums));
    }

}
