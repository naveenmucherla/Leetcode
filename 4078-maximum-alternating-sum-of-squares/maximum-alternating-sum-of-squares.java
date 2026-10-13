class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] squared = new long[n];
        for(int i = 0 ; i < n ; i++){
            squared[i] = (long)nums[i] * nums[i];
        }

        Arrays.sort(squared);
        long totalsum = 0;
        int left = 0;
        int right = n - 1;
        for(int i = 0 ; i < n ; i++){
            if(i % 2 == 0){
              totalsum += squared[right];
              right--;
            }
            else{
                totalsum -= squared[left];
                left++;
            }
        }
        return totalsum;
    }
}