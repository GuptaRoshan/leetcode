package array;

import java.util.ArrayList;
import java.util.List;

public class FindMoreThanOneDuplicates {

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int valueIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            valueIndex = Math.abs(nums[i]);

            if (nums[valueIndex - 1] < 0) {
                list.add(valueIndex);
            } else {
                nums[valueIndex - 1] *= -1;
            }
        }
        return list;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDuplicates(nums));
    }


}
