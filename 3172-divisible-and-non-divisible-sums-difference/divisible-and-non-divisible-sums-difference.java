class Solution {
    public int differenceOfSums(int n, int m) {
        int sub = 0, sum = 0;
        for(int i = 1 ; i <=n ; i++){
            if(i % m == 0){
                sub += i;
            }
            else{
                sum += i;
            }
        }
       return sum - sub;
    }
}