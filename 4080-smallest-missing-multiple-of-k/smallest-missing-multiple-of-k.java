class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> hash = new HashSet<>();
        for(int num : nums){
            hash.add(num);
        }
        int result = 0;
        for(int i =1 ; i <= nums.length + 1 ; i++){
            int product = i * k;
            if(!hash.contains(product)){
                result = product;
                break;
            }
        }
        return result;
    }
}