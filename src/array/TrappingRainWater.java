package array;

public class TrappingRainWater {

    public static int trap(int[] height) {
        int totalCount = 0;

        for (int i = 1; i < height.length; i++) {

            int leftMax = 0;
            for (int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }

            int rightMax = 0;
            for (int k = i + 1; k < height.length; k++) {
                rightMax = Math.max(rightMax, height[k]);
            }

            int temp = Math.min(leftMax, rightMax) - height[i];

            totalCount = totalCount + (Math.max(temp, 0));

        }

        return totalCount;
    }

    public static int trapTwoPointers(int[] height) {
        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = height.length - 1;
        int totalCount = 0;

        while (left < right) {

            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax < rightMax) {
                totalCount += (leftMax - height[left++]);

            } else {
                totalCount += (rightMax - height[right--]);
            }


        }

        return totalCount;
    }


    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
        System.out.println(trapTwoPointers(height));
    }
}
