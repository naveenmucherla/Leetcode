class Solution {
    public int maxPalindromes(String s, int k) {
        int count = 0;
        int prev = -1; // Tracks the end index of the last chosen palindrome
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            // 1. Check for a palindrome of length k
            int startK = i - k + 1;
            if (startK > prev && isPalindrome(s, startK, i)) {
                count++;
                prev = i; // Update the boundary
                continue; // Move to the next index immediately
            }
            
            // 2. Check for a palindrome of length k + 1
            int startK1 = i - k;
            if (startK1 > prev && isPalindrome(s, startK1, i)) {
                count++;
                prev = i; // Update the boundary
            }
        }
        
        return count;
    }
    
    // Helper method to verify if a substring is a palindrome
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}