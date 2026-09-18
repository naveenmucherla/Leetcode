class Solution {
    public String reverseVowels(String s) {
        char[] ch = s.toCharArray();
        int i = 0 , j = s.length()-1; 
        while(i < j){
           if(!isVowel(ch[i])){
            i++;
           }
           else if(!isVowel(ch[j])){
            j--;
           }
           else{
            char co = ch[i];
            ch[i] = ch[j];
            ch[j] = co;
            i++;
            j--;
           }
        }
        return String.valueOf(ch);
    }
    public boolean isVowel(char c)
    {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
               c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}