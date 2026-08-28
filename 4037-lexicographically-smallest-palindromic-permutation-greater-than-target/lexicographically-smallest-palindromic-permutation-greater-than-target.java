class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int halfLen = n / 2;

        // 1. Frequency calculation and validation
        int[] counts = new int[26];
        for (int i = 0; i < n; i++) {
            counts[s.charAt(i) - 'a']++;
        }

        int oddCount = 0;
        char mid = '\0';
        for (int i = 0; i < 26; i++) {
            if (counts[i] % 2 != 0) {
                oddCount++;
                mid = (char) (i + 'a');
            }
        }

        // If more than one character has an odd frequency, a palindrome is impossible
        if (oddCount > 1) {
            return "";
        }

        // Divide frequencies by 2 for building the first half
        int[] halfCounts = new int[26];
        for (int i = 0; i < 26; i++) {
            halfCounts[i] = counts[i] / 2;
        }

        char[] ans = new char[halfLen];
        int pos = 0;

        // 2. Try to match the target's prefix character by character
        while (pos < halfLen) {
            char tgtChar = target.charAt(pos);
            int idx = tgtChar - 'a';
            if (halfCounts[idx] > 0) {
                ans[pos] = tgtChar;
                halfCounts[idx]--;
                pos++;
            } else {
                break;
            }
        }

        // Base Check: If full prefix matched, verify if the mirrored palindrome is larger
        if (pos == halfLen) {
            String fullPal = makePalindrome(ans, mid, n);
            if (fullPal.compareTo(target) > 0) {
                return fullPal;
            }
        }

        // 3. Backtrack to find the first point of deviation
        while (true) {
            if (pos < halfLen) {
                char tgtChar = target.charAt(pos);
                int tgtIdx = tgtChar - 'a';

                // Find the smallest available character strictly greater than target[pos]
                int nextIdx = -1;
                for (int i = tgtIdx + 1; i < 26; i++) {
                    if (halfCounts[i] > 0) {
                        nextIdx = i;
                        break;
                    }
                }

                if (nextIdx != -1) {
                    ans[pos] = (char) (nextIdx + 'a');
                    halfCounts[nextIdx]--;

                    // Fill the remaining slots with the smallest available characters in ascending order
                    int dst = pos + 1;
                    for (int i = 0; i < 26; i++) {
                        while (halfCounts[i] > 0) {
                            ans[dst] = (char) (i + 'a');
                            halfCounts[i]--;
                            dst++;
                        }
                    }
                    return makePalindrome(ans, mid, n);
                }
            }

            // If we cannot deviate at index 0, no solution exists
            if (pos == 0) {
                return "";
            }

            // Backtrack one index and restore the used character to the pool
            pos--;
            char prevChar = target.charAt(pos);
            halfCounts[prevChar - 'a']++;
        }
    }

    // Helper method to reconstruct the complete palindrome from the first half array
    private String makePalindrome(char[] firstHalf, char mid, int fullLength) {
        StringBuilder sb = new StringBuilder(fullLength);
        sb.append(firstHalf);
        
        if (fullLength % 2 != 0) {
            sb.append(mid);
        }
        
        // Reverse and mirror the first half
        for (int i = firstHalf.length - 1; i >= 0; i--) {
            sb.append(firstHalf[i]);
        }
        
        return sb.toString();
    }
}