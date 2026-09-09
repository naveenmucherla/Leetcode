class Solution {
    public boolean checkPerfectNumber(int num) {
        int out = 0;
        for(int i = 1 ; i < num ; i++){
            if(num % i == 0){
                 out += i;
            }
        }
        if(out == num){
            return true;
        }
        return false;
    }
}