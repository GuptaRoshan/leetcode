package array;

public class ProductOfArraySelf {

    public static int[] productExceptSelf(int[] nums) {
        int[] product = new int[nums.length];

        int p = 1;
        for (int i = 0; i < nums.length; i++) {
            product[i] = p;
            p = p * nums[i];
        }

        p = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            product[i] = p * product[i];
            p = p * nums[i];
        }

        return product;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(productExceptSelf(nums));
    }

}
