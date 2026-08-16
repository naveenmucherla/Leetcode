class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = firstbound(nums , target , true);
        result[1] = firstbound(nums , target , false);

        return result;
    }
    private int firstbound(int[] nums , int target , boolean isfirst){
        int pos = -1;
        int left = 0 ;
        int right = nums.length-1;
        while(left <= right){
            int mid = left + (right - left ) / 2;
            if(nums[mid] == target){
                pos = mid;
                if(isfirst){
                    right = mid - 1;
                }
                else
                 left = mid+1;
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return pos;
    }
}