class Solution {
    public int minOperations(int[] nums, int x) {
       int totalsum = 0;
       for(int num : nums){
        totalsum += num;
       }
       int target = totalsum -x;
       if(target < 0){
        return -1;
       }
       if(target == 0){
        return nums.length;
       }
       int maxwindow = -1 , left = 0 , currentsum = 0;
       for(int right = 0 ; right < nums.length ; right++){
           currentsum += nums[right];
           while(currentsum > target && left <= right){
            currentsum -= nums[left];
            left++;
           }
           if(currentsum == target){
            maxwindow = Math.max(maxwindow , right -left + 1);
           }
       }
       return maxwindow == -1 ? -1 : nums.length - maxwindow;
    }
}