package backtrack;

public class IslandMatrixDFS {

    public static int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    DFS(i, j, grid);
                }
            }
        }
        return count;
    }

    public static void DFS(int row, int col, char[][] grid) {
        if (row < grid.length && col < grid[0].length && row >= 0 && col >= 0 && grid[row][col] == '1') {
            grid[row][col] = '0';
            DFS(row, col + 1, grid);
            DFS(row, col - 1, grid);
            DFS(row + 1, col, grid);
            DFS(row - 1, col, grid);
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
        System.out.println(numIslands(grid));
    }
}
