class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length < 3)
         return 0;
        Arrays.sort(nums);
        int prev = nums[0] + nums[1] + nums[2];
        for(int i = 0 ; i < nums.length-2 ; i++){
            int left = i+ 1;
            int right = nums.length -1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                int c1 = Math.abs(target - sum);
                int c2 = Math.abs(target - prev);
                if(c2 > c1)
                    prev = sum;
                if(sum == target) {  
                 prev = sum;
                 break;
                }
                else if(sum > target)
                 right--;
                else
                 left++;
            }
        }
        return prev;

    }
}