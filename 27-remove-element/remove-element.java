class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0 , right = left + 1;
        int count = 0;
        if(nums.length == 1 && nums[0] != val){
            count++;
        }
        else{
        while(left < nums.length){
            if(nums[left] != val){
                left++;
                right++;
                count++;
            }
            else if(nums.length > right && nums[right] == val){
                right++;
            }
           else if(nums.length > right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            count++;
            left++;
            right++;
           }
           else{
            left++;
           }
        }
        }
        return count;
    }
}