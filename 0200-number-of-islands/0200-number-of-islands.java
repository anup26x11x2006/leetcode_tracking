class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    islands++;
                    bfs(grid, r, c, rows, cols);
                }
            }
        }

        return islands;        
    }

    private void bfs(char[][] grid, int r, int c, int rows, int cols) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        grid[r][c] = '0';

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) {
            int[] point = q.poll();
            int row = point[0], col = point[1];

            for (int[] direction : directions) {
                int nr = row + direction[0];
                int nc = col + direction[1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == '1') {
                    q.add(new int[]{nr, nc});
                    grid[nr][nc] = '0';
                }
            }
        }
    }    
}