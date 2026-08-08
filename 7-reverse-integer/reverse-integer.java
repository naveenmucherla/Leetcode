class Solution {
    public int reverse(int x) {
        long output = 0;
        int sum = 0;
        while( x != 0){
            sum = x % 10;
            output = (output * 10) + sum;
            x = x/10;
        }

        if(output > Integer.MAX_VALUE || output < Integer.MIN_VALUE)
           return 0;
        
       return (int)output;
    }
}