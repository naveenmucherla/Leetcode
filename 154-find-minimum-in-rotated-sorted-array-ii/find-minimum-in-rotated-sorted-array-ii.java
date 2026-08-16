class Solution {
    public int findMin(int[] nums) {
        int left = 0 , right = nums.length - 1;
        int result = Integer.MAX_VALUE;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int r = Math.min(nums[mid] , nums[left]);
            int r1 = Math.min(nums[mid] , nums[right]);
            int r3 = Math.min(r , r1);
            if(nums[mid] > nums[left] )
              left = mid + 1;
            else if(nums[mid] == nums[left])
              left += 1;
            else
             right = mid -1;
            
            result = Math.min(result , r3);
        }
        return result;
    }
}