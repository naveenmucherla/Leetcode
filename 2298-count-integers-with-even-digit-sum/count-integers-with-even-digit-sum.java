class Solution {
    public int countEven(int num) {
        int digitsum = 0 , dummy = num ;

        while(dummy != 0){
            digitsum += dummy % 10;
            dummy = dummy /10;
        }

        return digitsum % 2 == 0 ? num /2 : (num - 1) / 2;
    }
}