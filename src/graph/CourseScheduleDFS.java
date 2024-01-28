package graph;

import java.util.ArrayList;
import java.util.List;

public class CourseScheduleDFS {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // Build the adjacency list
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int pre = prerequisite[1];
            adjacencyList.get(pre).add(course);
        }

        int[] visited = new int[numCourses];

        // Perform DFS for each course
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && hasCycle(i, adjacencyList, visited)) {
                return false; // If a cycle is detected, cannot finish all courses
            }
        }

        return true;
    }

    private static boolean hasCycle(int course, List<List<Integer>> adjacencyList, int[] visited) {
        if (visited[course] == 1) {
            return true; // Cycle detected
        }

        if (visited[course] == 2) {
            return false; // Already visited and no cycle found in this branch
        }

        visited[course] = 1; // Mark as currently visiting

        for (int nextCourse : adjacencyList.get(course)) {
            if (hasCycle(nextCourse, adjacencyList, visited)) {
                return true; // If a cycle is found in any branch, propagate the result
            }
        }

        visited[course] = 2; // Mark as visited and no cycle found in this branch
        return false;
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};
        System.out.println(canFinish(numCourses, prerequisites));
    }
}
