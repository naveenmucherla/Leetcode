class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        char[] result = new char[n];
        
        // Step 1: Try to match target as far as possible
        int matchLen = 0;
        while (matchLen < n) {
            char tChar = target.charAt(matchLen);
            if (count[tChar - 'a'] > 0) {
                result[matchLen] = tChar;
                count[tChar - 'a']--;
                matchLen++;
            } else {
                break;
            }
        }

        // Step 2: Backtrack from the maximum valid index (never let i start at n)
        // If matchLen == n, we start at n - 1 and explicitly restore result[n - 1] to count
        if (matchLen == n) {
            matchLen--;
            count[result[matchLen] - 'a']++;
        }

        for (int i = matchLen; i >= 0; i--) {
            char tChar = target.charAt(i);
            
            // Find the smallest available character strictly greater than target.charAt(i)
            int nextCharIdx = -1;
            for (int c = (tChar - 'a') + 1; c < 26; c++) {
                if (count[c] > 0) {
                    nextCharIdx = c;
                    break;
                }
            }

            if (nextCharIdx != -1) {
                // Place the strictly greater character
                result[i] = (char) (nextCharIdx + 'a');
                count[nextCharIdx]--;

                // Fill the rest of the string with the smallest available characters
                int p = i + 1;
                for (int c = 0; c < 26; c++) {
                    while (count[c] > 0 && p < n) {
                        result[p++] = (char) (c + 'a');
                        count[c]--;
                    }
                }
                return new String(result);
            }

            // Backtrack: Restore the character used at index i-1 to the count array
            if (i > 0) {  
                count[result[i - 1] - 'a']++;
            }
        }

        return "";
    }
}
