package graph;

import java.util.*;

public class PacificAtlanticOcean {
    public static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void bfs(Queue<int[]> queue, boolean[][] visited, int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] dir : dirs) {
                int x = cell[0] + dir[0];
                int y = cell[1] + dir[1];
                if (x < 0 || y < 0 || x >= m || y >= n || visited[x][y] || heights[x][y] < heights[cell[0]][cell[1]])
                    continue;
                visited[x][y] = true;
                queue.add(new int[]{x, y});
            }
        }
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] atlantic = new boolean[m][n];
        boolean[][] pacific = new boolean[m][n];
        Queue<int[]> a = new LinkedList<>();
        Queue<int[]> p = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            p.add(new int[]{i, 0});
            a.add(new int[]{i, m - 1});
            pacific[i][0] = true;
            atlantic[i][m - 1] = true;
        }

        for (int i = 0; i < n; i++) {
            p.add(new int[]{0, i});
            a.add(new int[]{n - 1, i});
            pacific[0][i] = true;
            atlantic[n - 1][i] = true;
        }

        bfs(p, pacific, heights);
        bfs(a, atlantic, heights);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> temp = new ArrayList<>(Arrays.asList(i, j));
                    result.add(temp);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] heights = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        pacificAtlantic(heights);

    }

}


