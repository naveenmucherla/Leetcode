class Solution {
    public int findMaxLength(int[] nums) {
        int[] prefix = new int[nums.length];
        if(nums[0] == 0){
            prefix[0] = -1;
        }
        else{
            prefix[0] = 1;
        }
        for(int i = 1 ; i < nums.length ; i++){
            int val = (nums[i] == 0) ? -1 : 1;
            prefix[i] = prefix[i-1] + val;
        }
        for(int num : prefix){
            System.out.print(num +" ");
        }
        HashMap<Integer , Integer> hash = new HashMap<>();
        int max = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(prefix[i] == 0){
              max = Math.max(max , i+ 1);
            }
            if(hash.containsKey(prefix[i])){
                max = Math.max(max , i - hash.get(prefix[i]));
            }
            else{
                hash.put(prefix[i] , i);
            }
        }
        return max;
    }
}