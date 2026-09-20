class Solution {
    public int reverseDegree(String s) {
        int sum = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            int bos = 27 - (c - 96);
            sum += bos * (i + 1); 
        }
        return sum;
    }
}