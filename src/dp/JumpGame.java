package dp;

public class JumpGame {
    public static boolean canJump(int[] nums) {
        int finalPosition = nums.length - 1;

        for (int index = nums.length - 2; index >= 0; index--) {
            if (index + nums[index] >= finalPosition) {
                finalPosition = index;
            }
        }
        return finalPosition == 0;
    }


    public static boolean canJump2(int[] nums) {
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            if (maxLen < i){
                return false;
            }
            maxLen = Math.max(i + nums[i], maxLen);
        }

        return true;
    }


    public static void main(String[] args) {
        int[] num = {2, 3, 1, 1, 4};
        System.out.println(canJump2(num));
    }

}
