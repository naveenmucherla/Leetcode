class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] arr = answerKey.toCharArray();
        int c1 = Count(arr , 'T' , k);
        int c2 = Count(arr , 'F' , k);
        int result = Math.max(c1 , c2);
        return result;
    }
    private int Count(char[] arr , char str  , int k){
        int left = 0 ;
        int count = 0;
        int max = 0;
        for(int right = 0 ; right < arr.length ; right++){
            if(arr[right] == str)
             count++;
            while(count > k){
                if(arr[left] == str)
                 count--;
                
                left++;
            }
            max = Math.max(max , right - left + 1);
        }
        return max;
    }
}