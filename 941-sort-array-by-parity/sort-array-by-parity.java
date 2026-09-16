class Solution {
    public int[] sortArrayByParity(int[] nums) {
       int left = 0 , right = nums.length-1;
       while(left <= right){
            if(nums[right] % 2 != 0){
                right--;
            }
            else if(nums[left] % 2 == 0){
                left++;
            }
            else{
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;

                left++;
                right--;
            }
        }
       return nums;
    }
}

/* int[] result = new int[nums.length];
         int i = 0 , j = nums.length-1;
        for(int num : nums){
           if(num % 2 == 0){
            result[i] = num;
            i++;
           }
           else{
            result[j] = num;
            j--;
           }
        }
        return result;
*/