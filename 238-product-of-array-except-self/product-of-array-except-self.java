class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answers = new int[nums.length];
        answers[0] = 1;
        for(int i = 1 ; i < nums.length ; i++){
            answers[i] = answers[i-1] * nums[i-1];
        }
        int right = 1;
        for(int i = nums.length-1 ; i >= 0 ; i--){
            answers[i] = answers[i] * right;
            right = right * nums[i];
        }

        return answers;
    }
}