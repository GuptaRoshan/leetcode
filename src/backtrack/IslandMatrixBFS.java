package backtrack;

import java.util.LinkedList;
import java.util.Queue;

public class IslandMatrixBFS {

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};


        IslandMatrixBFS islandMatrixBFS = new IslandMatrixBFS();
        System.out.println(islandMatrixBFS.numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        char[][] visited = new char[row][col];
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!(visited[i][j] == '0') && grid[i][j] == '1') {
                    count++;
                    BFS(i, j, grid, visited, queue);
                }
            }
        }
        return count;
    }

    public void BFS(int i, int j, char[][] grid, char[][] visited, Queue<Pair> queue) {
        int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        queue.add(new Pair(i, j));
        visited[i][j] = '0';
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            for (int[] dir : direction) {
                int row = pair.getKey() + dir[0];
                int col = pair.getValue() + dir[1];

                if (row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && grid[row][col] == '1' && !(visited[row][col] == '0')) {
                    visited[row][col] = '0';
                    queue.add(new Pair(row, col));
                }

            }
        }

    }

    public class Pair {
        private int key;
        private int value;

        public Pair(int row, int col) {
            this.key = row;
            this.value = col;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

    }
}
