class Solution {
    public int minOperations(String s) {
        int n = s.length();
        
        // 1. Check if already sorted
        boolean isSorted = true;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                isSorted = false;
                break;
            }
        }
        if (isSorted) return 0;
        
        // 2. Length 2 exception
        if (n == 2) return -1;
        
        // 3. Find absolute minimum and maximum characters
        char minChar = 'z';
        char maxChar = 'a';
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c < minChar) minChar = c;
            if (c > maxChar) maxChar = c;
        }
        
        // 4. Case 1: First is min, OR last is max
        if (s.charAt(0) == minChar || s.charAt(n - 1) == maxChar) {
            return 1;
        }
        
        // 5. Case 2: Either min or max appears anywhere in the middle elements
        for (int i = 1; i < n - 1; i++) {
            char c = s.charAt(i);
            if (c == minChar || c == maxChar) {
                return 2;
            }
        }
        
        // 6. Case 3: Absolute worst case rotation (e.g., "dbca")
        return 3;
    }
}