class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum > 9 * num){
            return "";
        }
        int q = sum / 9;
        int p = sum % 9;
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < q ;i++){
            sb.append('9');
        }
        if(p > 0){
            sb.append(p);
        }
        while(sb.length() < num){
            sb.append('0');
        }
        return sb.toString();
    }
}