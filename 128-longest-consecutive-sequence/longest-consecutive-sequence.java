class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer >map = new HashSet<>();

        for(int num : nums){
            map.add(num);
        }

        int longestStreak = 0 ;
        for(int num : map){
            if(!map.contains(num - 1)){
            int currentnum = num;
            int currentstrak = 1 ;

            while(map.contains(currentnum + 1 )){
                currentnum += 1;
                currentstrak += 1;
            }
            longestStreak = Math.max(longestStreak , currentstrak);
            }
        }
        return longestStreak;
    }
}