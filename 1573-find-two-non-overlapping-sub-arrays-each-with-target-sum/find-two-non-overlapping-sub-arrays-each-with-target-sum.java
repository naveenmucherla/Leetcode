class Solution {
    public int minSumOfLengths(int[] arr, int target) {
          int n = arr.length;
        
        // minLen[i] stores the minimum length of a subarray with sum = target found within arr[0...i]
        int[] minLen = new int[n];
        // Initialize with a large value representing infinity
        final int INF = Integer.MAX_VALUE / 2; 
        java.util.Arrays.fill(minLen, INF);
        
        // Map to store (prefixSum -> index)
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // Base case for prefix sum
        
        int prefixSum = 0;
        int minResult = INF;
        int currentMinLen = INF;
        
        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];
            map.put(prefixSum, i);
            
            // If there exists a previous prefix sum such that the subarray sums to target
            if (map.containsKey(prefixSum - target)) {
                int prevIdx = map.get(prefixSum - target);
                int currentLen = i - prevIdx;
                
                // Update the running minimum length for a single subarray seen so far
                currentMinLen = Math.min(currentMinLen, currentLen);
                
                // If a valid non-overlapping subarray exists before prevIdx
                if (prevIdx >= 0 && minLen[prevIdx] != INF) {
                    minResult = Math.min(minResult, currentLen + minLen[prevIdx]);
                }
            }
            
            // Store the best (minimum) length found up to the current index 'i'
            minLen[i] = currentMinLen;
        }
        
        return minResult >= INF ? -1 : minResult;
    }
}