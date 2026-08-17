class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0 ;
        for(int pile : piles){
            right = Math.max(right , pile);
        }
        int result = right;
        while(left <= right){
            int mid = left + (right - left) / 2;

            long totalhourSpend = find(piles , mid);
            if(totalhourSpend <= h){
                result = mid;
                right = mid -1;
            }
            else
             left = mid +1;
        }
        return result;
    }

    private long find(int[] nums , int k){
    long totalhours = 0 ;
        for(int num : nums){
            totalhours += (num + k -1) /k;
        }
        return  totalhours;
    }
}