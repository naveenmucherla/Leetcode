class Solution {
    public boolean checkPerfectNumber(int num) {
     int sum = 0;
     double n = Math.sqrt(num);
     for(int i = 1 ; i <= n ; i++){
        if(num % i == 0){
            sum += i + num / i;
        }
        if(n * n == num)
         sum -= num;
     }
        return (sum - num) == num;
     }
    
}