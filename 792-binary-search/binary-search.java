class Solution {
    public int search(int[] nums, int target) {
       int index = -1;
       int left = 0 ;
       int right = nums.length-1;
       while(left <= right){
        int mid = left + (right -  left ) / 2;
        if(nums[mid] == target){
          index = mid;
          break;
        }
        else if(nums[mid] < target)
         left = mid + 1;
        else 
         right = mid - 1;
       }
       return index;
    }
}