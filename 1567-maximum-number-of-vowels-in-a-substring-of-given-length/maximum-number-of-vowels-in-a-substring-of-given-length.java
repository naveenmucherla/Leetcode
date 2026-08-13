class Solution {
    public int maxVowels(String s, int k) {
        char[] str = s.toCharArray();
        int count = 0;
        for(int i = 0 ; i < k ; i++){
            if(str[i] == 'a' || str[i] == 'e' || str[i] == 'i' || str[i] == 'o' || str[i] == 'u'){
                count++;
            }
        }
        int j = 0 ;
       int maxcount = count;
        for(int i = k ; i < str.length ; i++){
            if(str[j] == 'a' || str[j] == 'e' || str[j] == 'i' || str[j] == 'o' || str[j] == 'u'){
                count--;
            }
            j++;
           if(str[i] == 'a' || str[i] == 'e' || str[i] == 'i' || str[i] == 'o' || str[i] == 'u'){
                count++;
            }
            maxcount = Math.max(maxcount , count);
        }
        return maxcount;
    }
}