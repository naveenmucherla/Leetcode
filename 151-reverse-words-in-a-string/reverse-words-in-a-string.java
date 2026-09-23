class Solution {
    public String reverseWords(String s) {
       
        String[] word = s.trim().split("\\s+");

        int j = word.length - 1 ,i = 0 ; 
        while(i < j){
            String temp = word[i];
            word[i] = word[j];
            word[j] = temp;
            i++;
            j--;
        }
      return String.join(" ",word);
    }
}