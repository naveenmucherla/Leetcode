class Solution {
    public int numberOfSets(int n, int k) {
        int MOD = 1_000_000_007;
        int totalObjects = n + k - 1;
        int choose = 2 * k;
        
        // If we need to choose more items than available, it's impossible
        if (totalObjects < choose) return 0;
        
        // DP table to compute combinations: C(N, K)
        int[][] dp = new int[totalObjects + 1][choose + 1];
        
        for (int i = 0; i <= totalObjects; i++) {
            dp[i][0] = 1; // C(i, 0) is always 1
            for (int j = 1; j <= Math.min(i, choose); j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD;
            }
        }
        
        return dp[totalObjects][choose];
    }
}