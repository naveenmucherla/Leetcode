class Solution {
    public int sortPermutation(int[] nums) {
         int ans = -1; // -1 represents all bits set to 1 in two's complement representation
        boolean isSorted = true;

        for (int i = 0; i < nums.length; i++) {
            // Check if the current element is out of its sorted position
            if (nums[i] != i) {
                if (isSorted) {
                    ans = nums[i];
                    isSorted = false;
                } else {
                    ans &= nums[i];
                }
            }
        }

        // If the array is already sorted, return 0 as specified by the problem.
        return isSorted ? 0 : ans;
    }
}