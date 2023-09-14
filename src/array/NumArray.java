package array;

class NumArray {
    public static int[] prefixSum;

    public NumArray(int[] nums) {
        prefixSum = nums;
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] += prefixSum[i - 1];
        }
    }

    public static int sumRange(int left, int right) {
        int leftValue = (left > 0) ? prefixSum[left - 1] : 0;
        return prefixSum[right] - leftValue;
    }

    public static void main(String[] args) {
        new NumArray(new int[]{1, 2, 3, 5, 5});
        System.out.println(sumRange(1, 2));
    }


}

