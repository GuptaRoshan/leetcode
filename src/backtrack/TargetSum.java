package backtrack;

public class TargetSum {

    static Integer count = 0;

    public static int findTargetSumWays(int[] nums, int target) {
        return backtrack(nums, target, 0, 0);
    }

    public static int backtrack(int[] nums, int target, int temp, int index) {
        if (index == nums.length && target == temp) {
            return 1;
        }

        int p = 0;
        int n = 0;

        if (index < nums.length) {
            p = backtrack(nums, target, temp + nums[index], index + 1);
            n = backtrack(nums, target, temp - nums[index], index + 1);
        }

        return p + n;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1};
        int target = 2;
        System.out.println(findTargetSumWays(nums, target));
    }


}
