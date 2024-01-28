package graph;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        int[][] matrix = new int[n][n];
        int[] inDegree = new int[n];

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int pre = prerequisites[i][1];
            matrix[pre][course] = 1;
            inDegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        int count = 0;

        while (!queue.isEmpty()) {
            int currCourse = queue.poll();
            count++;
            for (int i = 0; i < n; i++) {
                if (matrix[currCourse][i] != 0) {
                    inDegree[i]--;
                    if (inDegree[i] == 0) {
                        queue.add(i);
                    }
                }
            }
        }

        return count == n;
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        if (numCourses == 0) return null;

        int n = numCourses;
        int[][] matrix = new int[n][n];
        int[] inDegree = new int[n];
        int[] result = new int[n];

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int pre = prerequisites[i][1];
            matrix[pre][course] = 1;
            inDegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int currCourse = queue.poll();
            result[count++] = currCourse;
            for (int i = 0; i < n; i++) {
                if (matrix[currCourse][i] == 0) continue;
                if (--inDegree[i] == 0) {
                    queue.add(i);
                }
            }
        }

        return (count == n) ? result : new int[0];
    }

    public static void main(String[] args) {
        int numCourses = 1;
        int[][] prerequisites = new int[0][0];
        System.out.println(findOrder(numCourses, prerequisites));
    }


}
