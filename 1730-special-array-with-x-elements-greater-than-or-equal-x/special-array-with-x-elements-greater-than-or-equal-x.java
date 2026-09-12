class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0 ; i <= nums.length ; i++){
            int firstIndex = BinarySearch(nums , i);
            int n = nums.length - firstIndex;
            if(n == i){
                return i;
            }
        }
        return -1;
    }
    private int BinarySearch(int[] nums , int target){
        int low = 0 , high = nums.length-1;
        int ans = nums.length;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] >= target){
             ans = mid;
             high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
}