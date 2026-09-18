class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);
        
        // Step 1: Find the first and last occurrence of each character
        for (int i = 0; i < n; i++) {
            int charIdx = s.charAt(i) - 'a';
            if (first[charIdx] == -1) {
                first[charIdx] = i;
            }
            last[charIdx] = i;
        }
        
        List<Integer> validEndIdxs = new ArrayList<>();
        int[] validStarts = new int[n];
        Arrays.fill(validStarts, -1);
        
        // Step 2: Expand intervals to be valid (containing all instances of its characters)
        for (int i = 0; i < 26; i++) {
            if (first[i] == -1) continue;
            
            int start = first[i];
            int end = last[i];
            int current = start;
            boolean isValid = true;
            
            while (current <= end) {
                int charIdx = s.charAt(current) - 'a';
                // If this character started before our interval start, this interval is invalid
                if (first[charIdx] < start) {
                    isValid = false;
                    break;
                }
                // Extend end index if needed
                end = Math.max(end, last[charIdx]);
                current++;
            }
            
            // Store the valid interval indexed by its end position
            if (isValid) {
                validEndIdxs.add(end);
                validStarts[end] = start;
            }
        }
        
        // Step 3: Sort valid end indexes to apply the Greedy Interval Scheduling approach
        Collections.sort(validEndIdxs);
        List<String> result = new ArrayList<>();
        int prevEnd = -1;
        
        for (int end : validEndIdxs) {
            int start = validStarts[end];
            // If the current interval starts after the last chosen interval ends
            if (start > prevEnd) {
                result.add(s.substring(start, end + 1));
                prevEnd = end;
            } 
            // If the current interval is completely nested inside the last chosen interval,
            // we replace the last one with this smaller one to minimize total length.
            else if (start > validStarts[prevEnd]) {
                result.set(result.size() - 1, s.substring(start, end + 1));
                prevEnd = end;
            }
        }
        
        return result;
    }
}