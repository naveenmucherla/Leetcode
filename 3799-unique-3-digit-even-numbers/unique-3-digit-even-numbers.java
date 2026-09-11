class Solution {
    public int totalNumbers(int[] digits) {
        int[] digitCounts = new int[10];
        for (int digit : digits) {
            digitCounts[digit]++;
        }
        
        int uniqueEvenCount = 0;
        
        // Step 2: Iterate through all possible 3-digit even numbers
        for (int i = 100; i < 1000; i += 2) {
            int d1 = i / 100;          // Hundreds place
            int d2 = (i / 10) % 10;    // Tens place
            int d3 = i % 10;           // Units place
            
            // Step 3: Check if we have enough of each digit available
            digitCounts[d1]--;
            digitCounts[d2]--;
            digitCounts[d3]--;
            
            // If none of the counts dropped below 0, the number is valid
            if (digitCounts[d1] >= 0 && digitCounts[d2] >= 0 && digitCounts[d3] >= 0) {
                uniqueEvenCount++;
            }
            
            // Backtrack: restore counts for the next iteration
            digitCounts[d1]++;
            digitCounts[d2]++;
            digitCounts[d3]++;
        }
        
        return uniqueEvenCount;
    }
}