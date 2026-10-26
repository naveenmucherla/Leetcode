class Solution {
    public int countIslands(int[][] grid, int k) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        
        // Directions array for 4-directional movement (Up, Down, Left, Right)
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If we find a positive integer, it's a new island
                if (grid[i][j] > 0) {
                    long islandSum = dfs(grid, i, j, m, n, dirs);
                    
                    // Check if the total island value is divisible by k
                    if (islandSum % k == 0) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
    
    private long dfs(int[][] grid, int r, int c, int m, int n, int[][] dirs) {
        // Base case: check boundaries and if it's not land (0 or already visited)
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] <= 0) {
            return 0;
        }
        
        // Add current cell value to the island total
        long currentVal = grid[r][c];
        
        // Mark the current cell as visited by setting it to 0
        grid[r][c] = 0;
        
        // Traverse all 4 neighbors and accumulate their sum
        for (int[] dir : dirs) {
            currentVal += dfs(grid, r + dir[0], c + dir[1], m, n, dirs);
        }
        
        return currentVal;
    }
}