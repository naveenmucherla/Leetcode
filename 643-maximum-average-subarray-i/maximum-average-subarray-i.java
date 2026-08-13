class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int avg = 0 ;
        for(int i = 0 ; i < k ; i++){
            avg += nums[i];
        }
        int maxAvg = avg;
        int j = 0 ;
        for(int i = k ; i < nums.length ; i++){
            avg = avg - nums[j] + nums[i];
            j++;
            maxAvg = Math.max(maxAvg , avg);
        }
        double abg = (double) maxAvg / k;
        return (double) abg;
    }
}