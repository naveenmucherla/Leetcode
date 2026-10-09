class Solution {
    public boolean judgeSquareSum(int c) {
        double sq = Math.sqrt(c);
        int j = (int) sq + 1;

        int i = 0;

        while(i <= j){
            long product = (long)i * i + (long)j * j;
            if( product == c){
                return true;
            }
            else if(product < c){
                i++;
            }
            else{
                j--;
            }
        }
        return false;
    }
}