class Solution {
    public boolean isSameAfterReversals(int num) {
        if(num >= 0 && num  < 10){
            return true;
        }
        int x1 = Reverse(num);
        int y = Reverse(x1);

        if(y == num){
            return true;
        }
        return false;
    }
    private int Reverse(int num){
        int rev = 0;
        int x = num;
        while( x > 0){
            int digit = x % 10;
            rev = rev * 10 + digit;
            x = x /10;
        }
        return rev;
    }
}