class Solution {
    public int countCommas(int n) {
        int count = 0;
        int m = n;
        while(n > 0){
            count += 1;
            n = n/10;
        }
        if(count > 3){
            return m - 1000 + 1;
        }
        return 0;
    }
}