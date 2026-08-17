class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for(int w : weights){
            left = Math.max(left , w);
            right += w;
        }
        int result = right;

        while(left <= right){
            int mid = left + (right - left) / 2;
            int totalDays = find(mid , weights);

            if(totalDays <= days){
                result = mid;
                right = mid - 1;
            }
            else 
             left = mid + 1;
        }
        return result;
    }
    private int find(int cap , int[] weights){
        int days = 1;
        int current = 0;
        for(int w : weights){
            if(current + w > cap){
                days++;
                current = 0 ;
            }
            current += w;
        }
        return days;
    }
}