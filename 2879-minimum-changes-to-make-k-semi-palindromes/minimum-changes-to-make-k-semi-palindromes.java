import java.util.Arrays;

class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int[][] cost = new int[n][n];

        // Step 1: Precompute minimum changes for every substring s[i..j] of length >= 2
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                cost[i][j] = getMinChanges(s, i, j);
            }
        }

        // Step 2: DP to partition s into k substrings
        int INF = 1_000_000;
        int[][] dp = new int[n + 1][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }
        dp[0][0] = 0;

        for (int p = 1; p <= k; p++) {
            // Each partition needs at least 2 characters, so i starts at 2 * p
            for (int i = 2 * p; i <= n; i++) {
                for (int m = 2 * (p - 1); m <= i - 2; m++) {
                    if (dp[m][p - 1] != INF) {
                        dp[i][p] = Math.min(dp[i][p], dp[m][p - 1] + cost[m][i - 1]);
                    }
                }
            }
        }

        return dp[n][k];
    }

    // Helper to calculate minimum changes to make s[start..end] a semi-palindrome
    private int getMinChanges(String s, int start, int end) {
        int len = end - start + 1;
        int minChanges = Integer.MAX_VALUE;

        // Check all valid divisors d (1 <= d < len)
        for (int d = 1; d < len; d++) {
            if (len % d != 0) continue;

            int currentChanges = 0;
            // Check each of the d interleaved groups
            for (int rem = 0; rem < d; rem++) {
                int left = start + rem;
                int right = end - (d - 1 - rem);

                // Two-pointer palindrome check within the current group
                while (left < right) {
                    if (s.charAt(left) != s.charAt(right)) {
                        currentChanges++;
                    }
                    left += d;
                    right -= d;
                }
            }
            minChanges = Math.min(minChanges, currentChanges);
        }

        return minChanges;
    }
}
