class Solution {
    public int maxFreqSum(String s) {
        int[] arr = new int[26];
        for(char ch : s.toCharArray()){
             arr[ch - 'a']++;
        }
        int vomax = 0 , cons = 0;
        for(int i = 0 ;i < 26 ; i++){
            if(i == 0 || i == 4 || i == 8 || i == 14 || i == 20){
                vomax = Math.max(vomax , arr[i]);
            }
            else{
                cons = Math.max(cons ,arr[i]);
            }
        }
        return cons + vomax;
    }
}