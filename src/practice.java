public class practice {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 2, 3};
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            int curr = nums[i];
            for (int j = i; j < nums.length; j++) {
                int next = nums[j];
                if (next > curr) {
                    curr = nums[j];
                    count++;
                }
            }
            max = Math.max(max, count);
        }

        System.out.println(max);

    }

}
