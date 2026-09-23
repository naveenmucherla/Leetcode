class Solution {
    public boolean validPalindrome(String s) {
        int i = 0 , j = s.length()-1;
        int count = 0;
        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }
            else{
                return isPallindrom(s , i+1 , j) || isPallindrom(s , i , j-1);
            }
            
        }
        return true;
       
    }
    private boolean isPallindrom(String s , int i , int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}