class Solution {
    public boolean checkDivisibility(int n) {
        int vis = n;
        int sum = 0;
        int product = 1;
        while(vis > 0){
            int digit = vis % 10;
            sum += digit;
            product *= digit;
            vis = vis/10;
        }
        if(n % (sum + product) == 0)
         return true;
        
        return false;
    }
}