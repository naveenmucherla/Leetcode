class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
       int count = numBottles;
     
       while (numBottles >= numExchange) {
        int numBottle = numBottles / numExchange; 
        int rem = numBottles % numExchange;       
        
        count += numBottle;                        
        numBottles = numBottle + rem;             
       }
       return count;
    }
}
