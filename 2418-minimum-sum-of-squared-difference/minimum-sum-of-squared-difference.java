class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
         int n = nums1.length;
        long k = (long) k1 + k2;
        
        // Track the actual maximum difference dynamically to avoid empty iterations
        int maxDiff = 0;
        int[] count = new int[100001];
        long totalDiffSum = 0;
        
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            if (diff > 0) {
                count[diff]++;
                totalDiffSum += diff;
                if (diff > maxDiff) {
                    maxDiff = diff;
                }
            }
        }
        
        // Fast-path: If k covers all differences, every single difference can become 0
        if (totalDiffSum <= k) {
            return 0;
        }
        
        // Process only from the actual maximum difference downwards
        for (int d = maxDiff; d > 0; d--) {
            if (count[d] > 0) {
                int take = (int) Math.min(k, count[d]);
                k -= take;
                count[d] -= take;
                count[d - 1] += take;
            }
            
            if (k == 0) {
                break;
            }
        }
        
        // Calculate the final answer
        long minSumSquare = 0;
        for (int d = 1; d <= maxDiff; d++) {
            if (count[d] > 0) {
                minSumSquare += (long) count[d] * d * d;
            }
        }
        
        return minSumSquare;
    }
}