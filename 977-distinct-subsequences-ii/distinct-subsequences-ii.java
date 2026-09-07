class Solution {
    public int distinctSubseqII(String s) {
         int MOD = 1_000_000_007;
        int n = s.length();
        
        // dp[i] stores the total number of distinct subsequences using s[0...i-1]
        long[] dp = new long[n + 1];
        dp[0] = 1; // Base case: 1 empty subsequence ""
        
        // lastSeen[c] stores the last dp index where character c appeared
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);
        
        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i - 1);
            int charIdx = c - 'a';
            
            // Double the count of previous combinations
            dp[i] = (dp[i - 1] * 2) % MOD;
            
            // If the character has appeared before, subtract the duplicate combinations
            if (lastSeen[charIdx] != -1) {
                dp[i] = (dp[i] - dp[lastSeen[charIdx] - 1] + MOD) % MOD;
            }
            
            // Record the current character's position
            lastSeen[charIdx] = i;
        }
        
        // Subtract 1 to remove the empty subsequence and return
        return (int) (dp[n] - 1 + MOD) % MOD;
    }
    
}