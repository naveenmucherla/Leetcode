class Solution {
    public int stoneGameVIII(int[] stones) {
        int currentsum = 0;
        for(int num : stones){
            currentsum += num;
        }
        int maxDiff = currentsum;
        for(int i = stones.length-1 ; i > 1 ; i--){
            currentsum -= stones[i];
            maxDiff = Math.max(maxDiff , currentsum - maxDiff);
        }
        return maxDiff;
    }
}