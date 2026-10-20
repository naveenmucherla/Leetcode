class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int sumOfK = 0;
        
        // Step 1: Find all divisors k of n
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
            }
        }
        
        // Step 2: Validate each divisor k
        for (int k : divisors) {
            if (isValid(nums, n, k)) {
                sumOfK += k;
            }
        }
        
        return sumOfK;
            }
            
    private boolean isValid(int[] nums, int n, int k) {
        int previousMax = Integer.MIN_VALUE;
        
        // Traverse the array block by block of size k
        for (int start = 0; start < n; start += k) {
            int end = start + k;
            
            // Count descending steps circularly within the current block
            int descendingCount = 0;
            int dropIndex = -1;
            
            for (int i = start; i < end; i++) {
                int nextIndex = (i + 1 == end) ? start : i + 1;
                if (nums[i] > nums[nextIndex]) {
                    descendingCount++;
                    dropIndex = i;
                }
            }
            
            // If there's more than 1 descending transition, this block cannot be sorted via rotation
            if (descendingCount > 1) {
                return false;
            }
            
            int currentMin, currentMax;
            if (descendingCount == 0) {
                // The block is already fully non-decreasingly sorted
                currentMin = nums[start];
                currentMax = nums[end - 1];
            } else {
                // The block contains exactly 1 drop point.
                // After optimal rotation, the element right after the drop point becomes the new minimum,
                // and the element at the drop point becomes the new maximum.
                int nextToDrop = dropIndex + 1 == end ? start : dropIndex + 1;
                currentMin = nums[nextToDrop];
                currentMax = nums[dropIndex];
            }
            
            // Check cross-block sorting validity: previous block's max must be <= current block's min
            if (currentMin < previousMax) {
                return false;
            }
            
            previousMax = currentMax;
        }
        
        return true;
    }
}