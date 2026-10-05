class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] result = new int[nums.length];
        int i = 0 , j = 1;
        for(int num : nums){
            if(num > 0){
                result[i] = num;
                i += 2;
            }
            else{
                result[j] = num;
                j += 2;
            }
        }
        return result;
    }
}