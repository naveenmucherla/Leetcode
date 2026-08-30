class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n; // Edge case: if 1 or 2 elements, we must delete all of them

        int minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE;
        int minInd = 0, maxInd = 0;

        // Step 1: Find the true 0-based indices of the min and max elements
        for (int i = 0; i < n; i++) {
            if (nums[i] < minVal) {
                minVal = nums[i];
                minInd = i;
            }
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                maxInd = i;
            }
        }

        // Step 2: Normalize indices so 'left' is always the smaller index
        int left = Math.min(minInd, maxInd);
        int right = Math.max(minInd, maxInd);

        // Step 3: Evaluate the 3 possible deletion strategies
        // Strategy 1: Delete both from the left side
        int delLeft = right + 1;

        // Strategy 2: Delete both from the right side
        int delRight = n - left;

        // Strategy 3: Delete 'left' from the left side, and 'right' from the right side
        int delBoth = (left + 1) + (n - right);

        // Return the absolute minimum moves required
        return Math.min(delLeft, Math.min(delRight, delBoth));
    }
}
