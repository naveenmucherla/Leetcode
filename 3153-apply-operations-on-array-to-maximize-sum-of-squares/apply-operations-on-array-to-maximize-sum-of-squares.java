class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int mod = 1_000_000_007; 
        int[] bits = new int[32];
        for(int num : nums){
            for(int i = 0 ; i < 32 ; i++){
            if(((num >> i) & 1) == 1){
                bits[i]++;
            }
          }
        }
        long totalsquare = 0;
        for(int s = 0 ; s < k ; s++){
            long current = 0;
            for(int i = 0 ; i < 32 ; i++){
                if(bits[i] > 0){
                    current |= (1L << i);
                    bits[i]--;
                }
            }
            totalsquare = (totalsquare + (current  * current)) % mod;
        }
        return (int)totalsquare;
    }
}