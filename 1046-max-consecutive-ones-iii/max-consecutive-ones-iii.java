class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxresult = 0;
        int left = 0 ;
        int zeros = 0;
        for(int right = 0 ; right < nums.length ; right++){
            if(nums[right] == 0){
                zeros++;
            }
            while(zeros > k){
                if(nums[left] == 0)
                  zeros--;
                
                left++;
            }
            maxresult = Math.max(maxresult , right -left +1);
        }
        return maxresult;
    }
}