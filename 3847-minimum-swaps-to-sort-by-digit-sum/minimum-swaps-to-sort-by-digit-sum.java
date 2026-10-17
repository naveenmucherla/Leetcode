class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        
        // Element structure to store the number, its original index, and its digit sum
        Element[] elements = new Element[n];
        for (int i = 0; i < n; i++) {
            elements[i] = new Element(nums[i], i, getDigitSum(nums[i]));
        }
        
        // Sort based on the custom criteria
        Arrays.sort(elements, (a, b) -> {
            if (a.digitSum != b.digitSum) {
                return Integer.compare(a.digitSum, b.digitSum);
            }
            return Integer.compare(a.val, b.val);
        });
        
        // Use a boolean array to track visited elements during cycle decomposition
        boolean[] visited = new boolean[n];
        int totalSwaps = 0;
        
        for (int i = 0; i < n; i++) {
            // If already visited or already in the correct position, skip
            if (visited[i] || elements[i].originalIndex == i) {
                continue;
            }
            
            // Find the size of the cycle
            int cycleSize = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = elements[j].originalIndex;
                cycleSize++;
            }
            
            // For a cycle of size L, we need L - 1 swaps
            if (cycleSize > 0) {
                totalSwaps += (cycleSize - 1);
            }
        }
        
        return totalSwaps;
    }
    
    // Helper method to compute the sum of digits of a number
    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    
    // Helper class to wrap the values nicely
    private static class Element {
        int val;
        int originalIndex;
        int digitSum;
        
        Element(int val, int originalIndex, int digitSum) {
            this.val = val;
            this.originalIndex = originalIndex;
            this.digitSum = digitSum;
        }
    }
}