class Solution {
    public boolean checkPerfectNumber(int num) {
     int sum = 0;
     for(int i = 1 ; i <= Math.sqrt(num) ; i++){
        if(num % i == 0){
            sum += i + num / i;
        }
        if(Math.sqrt(num) * Math.sqrt(num) == num)
         sum -= num;
     }
        return (sum - num) == num;
     }
    
}