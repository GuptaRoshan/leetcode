package array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(Integer.valueOf(nums[i]))) {
                result[0] = map.get(Integer.valueOf(nums[i]));
                result[1] = i;
                break;
            } else {
                map.put(target - nums[i], i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 17;
        System.out.println(twoSum(nums, target));
    }
}
