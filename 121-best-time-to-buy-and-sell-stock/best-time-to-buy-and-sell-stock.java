class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxprofit = 0 ;
        int j = 1;
        int i = 0;
        while(j < prices.length){
            if(prices[i] > prices[j]){
                min = prices[j];
                i = j;
            }
            int sum = prices[j] - min;
            j++;
            if(sum > maxprofit){
                maxprofit = sum;
            }
        }
        

        return maxprofit;
    }
}