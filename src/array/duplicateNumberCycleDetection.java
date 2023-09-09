package array;

public class duplicateNumberCycleDetection {

    public static int singleNumber(int[] nums) {
        int sp = nums[0];
        int fp = nums[0];
        while (true) {
            sp = nums[sp];
            fp = nums[nums[fp]];
            if (sp == fp) {
                break;
            }
        }

        int ptr = nums[0];
        while (ptr != sp) {
            ptr = nums[ptr];
            sp = nums[sp];
        }

        return ptr;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums));
    }
}
