class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1count = new int[26];
        int[] s2count = new int[26];
        if(s1 == null || s2 == null || s1.length() > s2.length())
          return false;
        for(int i = 0 ; i < s1.length() ; i++){
            s1count[s1.charAt(i) - 'a']++;
            s2count[s2.charAt(i) - 'a']++;
        }
        if(matches(s1count , s2count))
            return true;
        
        for(int left = 0 ; left < s2.length() - s1.length() ; left++){
           int right = left + s1.length();
           s2count[s2.charAt(right) - 'a']++;
           s2count[s2.charAt(left) - 'a']--;

           if(matches(s1count , s2count)){
             return true;
           }
        }
        return false;
    }
    private boolean matches(int[] a , int[] b){
        for(int i = 0 ; i < a.length ; i++){
            if(a[i] != b[i])
             return false;
        }
        return true;
    }
}