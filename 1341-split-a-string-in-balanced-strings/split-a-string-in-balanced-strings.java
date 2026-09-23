class Solution {
    public int balancedStringSplit(String s) {
        //s = s.toUpperCase();
        char c = (s.charAt(0) == 'R')?'R' : 'L';
        int count = 1 , output = 0;
        for(int i = 1 ; i < s.length() ; i++){
            if(s.charAt(i) == c){
                count++;
            }
            else{
                count--;
            }
            
            if(count == 0){
                output++;
            }
        }
        return output;
    }
}