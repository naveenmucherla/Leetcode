class Solution {
    public int gcdOfOddEvenSums(int n) {
        int oddsum = 0;
        int evensum = 0;
       
        for(int i = 1 ; i  <= n + n ; i++ ){
            if(i % 2 == 0){
                evensum += i;
            }
            else{
                oddsum += i;
            }
        }
        int output = GCD(oddsum , evensum);

        return output;
    }
    private int GCD(int num1 ,int num2){
      int a = num2;
      int b = num1;
      while(b != 0){
        int temp = a;
        a = b;
        b = temp % b;
      }
      return a;
    }
}