package array.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class intervalListIntersections {

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0;
        int j = 0;
        List<int[]> result = new ArrayList<>();

        while (i < firstList.length && j < secondList.length) {

            int first_start = firstList[i][0];
            int first_end = firstList[i][1];

            int second_start = secondList[j][0];
            int second_end = secondList[j][1];

            // Merging interval condition
            if (first_start <= second_end && second_start <= first_end) {

                int start = Math.max(first_start, second_start);
                int end = Math.min(first_end, second_end);

                int[] interval = new int[]{start, end};
                result.add(interval);
            }

            // Merging two sorted list condition
            if (first_end <= second_end) {
                i++;
            } else {
                j++;
            }
        }

        return result.toArray(new int[result.size()][2]);
    }


    public static void main(String[] args) {
        int[][] firstList = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] secondList = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        System.out.println(Arrays.deepToString(intervalIntersection(firstList, secondList)));
    }
}
