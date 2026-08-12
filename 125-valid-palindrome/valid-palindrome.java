class Solution {
    public boolean isPalindrome(String s) {
        String str1 = s.replaceAll("[^a-zA-Z0-9]" , "").toLowerCase();
        char[] str = str1.toCharArray();
        int i = 0;
        int j = str.length-1;
        while(i < j){
            char k = str[i];
            char l = str[j];
            if(k == l){
                i++;
                j--;
            }
            else
              return false;
        }
        return true;
    }
}