class Solution {
    public int maximumCount(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int ncount = -1;
        int pcount = nums.length;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] < 0){
              ncount = mid;
              low = mid + 1;
            }
            else{
                high =  mid - 1;
            }
        }
        low = 0;
        high = nums.length-1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] > 0){
              pcount = mid;
              high = mid - 1;
            }
            else{
                low =  mid + 1;
            }
        }

        int n = ncount + 1;
        int p = nums.length - pcount;
        return Math.max(n , p);
    }
}