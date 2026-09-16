class Solution {
    public void sortColors(int[] nums){
      int left = 0 , mid =0 , right = nums.length-1;

      while(mid <= right){
        if(nums[mid] == 0){
            Swap(nums , left , mid);
            mid++;
            left++;
         }
         else if(nums[mid] == 1){
            mid++;
         }
         else{
            Swap(nums , mid , right);
            right--;
         }
      }

    }
    private void Swap(int[] nums , int left , int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}