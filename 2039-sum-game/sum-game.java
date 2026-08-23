class Solution {
    public boolean sumGame(String num) {
        int n = num.length() / 2;
        String str1 = num.substring(0 , n);
        String str2 = num.substring(n);
        int s1 = Find(str1);
        int s2 = Find(str2);
        int q1 = Count(str1);
        int q2 = Count(str2);
        if((q1 - q2) % 2 != 0)
         return true;

        if((s1 - s2) == ((q2 - q1) * 9/ 2)) {
            return false;
        }
     return true;
    }
    private int Count(String num){
        int count = 0;
        for(char c : num.toCharArray()){
            if(c == '?'){
              count++;
            }
        }
        return count;
    }
    private int Find(String num){
        int sum =0;
        for(int c : num.toCharArray()){
            if(c == '?')
             continue;
            int a = Character.getNumericValue(c);
            sum += a;
        }
        return sum;
    }
}