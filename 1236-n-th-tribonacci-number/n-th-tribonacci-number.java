class Solution {
    public int tribonacci(int n) {
        if(n == 1 || n ==2){
            return 1;
        }
        if(n == 0){
            return 0;
        }
        int first = 0;
        int second = 1;
        int third = 1;
        for(int i = 2 ; i < n ; i++){
            int curr = first + second + third;
            first = second;
            second = third;
            third = curr;
        }
        return third;
    }
}