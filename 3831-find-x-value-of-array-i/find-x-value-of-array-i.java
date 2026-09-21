class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        
        // dp[p] stores the count of subarrays ending at the current index with product % k == p
        long[] dp = new long[k];
        
        for (int num : nums) {
            long[] nextDp = new long[k];
            int rem = num % k;
            
            // Case 1: Start a new subarray at the current element
            nextDp[rem] += 1;
            
            // Case 2: Extend existing subarrays from the previous element
            for (int p = 0; p < k; p++) {
                if (dp[p] > 0) {
                    int nextRem = (int) (((long) p * rem) % k);
                    nextDp[nextRem] += dp[p];
                }
            }
            
            // Add the counts from the current ending position to the global result
            for (int x = 0; x < k; x++) {
                result[x] += nextDp[x];
            }
            
            // Move to the next element
            dp = nextDp;
        }
        
        return result;
    }
}