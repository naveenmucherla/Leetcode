class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1_000_000_007;
        
        // An empty prefix sum of 0 is considered even, so evenCount starts at 1
        long oddCount = 0;
        long evenCount = 1;
        
        long currentPrefixSum = 0;
        long result = 0;
        
        for (int num : arr) {
            currentPrefixSum += num;
            
            if (currentPrefixSum % 2 != 0) {
                // Current prefix sum is odd:
                // Pair it with all previous even prefix sums to form odd-sum subarrays
                result = (result + evenCount) % MOD;
                oddCount++;
            } else {
                // Current prefix sum is even:
                // Pair it with all previous odd prefix sums to form odd-sum subarrays
                result = (result + oddCount) % MOD;
                evenCount++;
            }
        }
        
        return (int) result;
    }
}
