public class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        // dp[i][j] stores the number of subsequences of s[0...i-1] that match t[0...j-1]
        int[][] dp = new int[m + 1][n + 1];
        
        // Base case: An empty string t can be formed by 1 way from any prefix of s
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        
        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If characters match, we can either include or exclude s.charAt(i-1)
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    // If characters don't match, we can only exclude s.charAt(i-1)
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        return dp[m][n];
    }
}
