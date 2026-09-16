class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int left = 0 , right = nums.length-1;
        int output = 0;
        while(left <= right){
            int dum = nums[left] + nums[right];
            output = Math.max(output , dum);
            left++;
            right--;
        }
        return output;
    }
}