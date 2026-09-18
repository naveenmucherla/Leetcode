class Solution {
    public int firstMissingPositive(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] <= 0){
                continue;
            }
            if(nums.length -1 > i && nums[i + 1] == nums[i]){
                continue;
            }
            else{
                count++;
                if(count != nums[i]){
                    return count;
                }
            }
        }
        return count + 1;
    }
}