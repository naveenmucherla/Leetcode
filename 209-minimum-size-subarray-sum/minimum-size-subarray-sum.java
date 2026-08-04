class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int count = Integer.MAX_VALUE ;
        int sum = 0;
        int j = 0;
        for(int i = 0 ; i < nums.length ; i++){
             sum += nums[i];
            if(nums[i] >= target)
              return 1;
            while(sum >= target){
               count = Math.min(count , i - j +1);
               sum -= nums[j];
               j++;
            }
        }
        if(count == Integer.MAX_VALUE)
          return 0;
       return count;

    }
}