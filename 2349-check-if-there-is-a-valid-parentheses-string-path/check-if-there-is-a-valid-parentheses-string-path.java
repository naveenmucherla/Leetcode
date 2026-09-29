class Solution {
    public boolean hasValidPath(char[][] grid) {
          int m = grid.length;
        int n = grid[0].length;
        
        // A valid path must have an even length to balance '(' and ')'
        // Path length is always m + n - 1
        if ((m + n - 1) % 2 != 0) {
            return false;
        }
        
        // The starting character cannot be ')' and the ending character cannot be '('
        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
            return false;
        }
        
        // Max possible open parentheses at any point cannot exceed half of the total path length
        int maxOpen = (m + n) / 2;
        
        // dp[i][j][k] stores whether we can reach (i, j) with 'k' open parentheses
        boolean[][][] dp = new boolean[m][n][maxOpen + 1];
        
        // Base case: starting at (0,0) gives us 1 open parenthesis
        dp[0][0][1] = true;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= maxOpen; k++) {
                    // If the state is not reachable, skip it
                    if (!dp[i][j][k]) continue;
                    
                    // Try moving down
                    if (i + 1 < m) {
                        int nextK = k + (grid[i + 1][j] == '(' ? 1 : -1);
                        if (nextK >= 0 && nextK <= maxOpen) {
                            dp[i + 1][j][nextK] = true;
                        }
                    }
                    
                    // Try moving right
                    if (j + 1 < n) {
                        int nextK = k + (grid[i][j + 1] == '(' ? 1 : -1);
                        if (nextK >= 0 && nextK <= maxOpen) {
                            dp[i][j + 1][nextK] = true;
                        }
                    }
                }
            }
        }
        
        // The answer is true if we can reach the bottom-right corner with 0 unmatched open parentheses
        return dp[m - 1][n - 1][0];
    }
}