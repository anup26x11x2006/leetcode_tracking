class Solution {
    int rows, cols;
    int count = 0;

    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        for(int row = 0; row < rows ; row++){
            check(row, grid);
        }
        return count;
    }

    public void check(int row, char[][] grid){

        for(int col = 0 ; col < cols ; col++){
            if(grid[row][col] == '1'){
                count++;
                dfs(row, col, grid);
            }
        }
    }

    public void dfs(int row, int col, char[][] grid){
        grid[row][col] = '*';
        if(row > 0 && grid[row-1][col] == '1'){
            dfs(row-1, col, grid);
        }
        if(row < rows - 1 && grid[row + 1][col] == '1'){
            dfs(row + 1, col, grid);
        }

        if(col > 0 && grid[row][col - 1] == '1'){
            dfs(row, col - 1, grid);
        }
        if(col < cols - 1 && grid[row][col + 1] == '1'){
            dfs(row, col + 1, grid);
        }
    
    }

}