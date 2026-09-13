class Solution {
    public int[] sortedSquares(int[] nums) {
         for(int i=0;i<nums.length;i++){
            nums[i]=nums[i]*nums[i];
        }

        int result[] = new int[nums.length];
        int left=0,right=nums.length-1,curr=nums.length-1;

        while(left<=right){
            if(nums[left]>nums[right]){
                result[curr--]=nums[left++];
            }else{
                result[curr--]=nums[right--];
            }
        }
        return result;
    }
}