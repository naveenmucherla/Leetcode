class Solution {
    public int missingNumber(int[] nums) {
        int  n = nums.length;
       int sum = (n * (n+1))/2;
       int actual_sum = 0;
       for(int num : nums){
          actual_sum += num;
       }

       int k  = sum - actual_sum;

       return k;
    }
}