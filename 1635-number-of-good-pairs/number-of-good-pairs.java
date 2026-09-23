class Solution {
    public int numIdenticalPairs(int[] nums) {
        int goodpairs = 0;
        Map<Integer, Integer> hash = new HashMap<>();
        for(int num : nums){
            int count = hash.getOrDefault(num , 0);
            goodpairs += count;
            hash.put(num , hash.getOrDefault(num, 0) + 1);
        }
        return goodpairs;
    }
}