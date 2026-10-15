class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int total = 0;
        for(int i = 0 ; i < n ; i++){
            HashSet<Integer> hash = new HashSet<>();
            for(int j = i ; j < n ; j++){
                hash.add(nums.get(j));
                int dist = hash.size();
                total += dist * dist;
            }
        }
        return total;
    }
}