class Solution {
    public int closedIsland(int[][] grid) {
         if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        // Step 1: Flood fill all land (0) connected to the boundaries and turn them into water (1)
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If it's a boundary cell and contains land
                if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
                    if (grid[i][j] == 0) {
                        dfs(grid, i, j);
                    }
                }
            }
        }
        
        // Step 2: Count the remaining closed islands in the interior grid
        int closedIslandsCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    closedIslandsCount++;
                    dfs(grid, i, j); // Sink the counted island to avoid recount
                }
            }
        }
        
        return closedIslandsCount;
    }
    
    private void dfs(int[][] grid, int r, int c) {
        // Base case: check boundary limits and if the cell is water (1)
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 1) {
            return;
        }
        
        // Mark the current land cell as water so we don't visit it again
        grid[r][c] = 1;
        
        // Traverse in all 4 orthogonal directions
        dfs(grid, r + 1, c); // Down
        dfs(grid, r - 1, c); // Up
        dfs(grid, r, c + 1); // Right
        dfs(grid, r, c - 1); // Left
    }
}