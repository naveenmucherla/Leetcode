class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length() || s == null || t == null)
          return false;
        else{
            int[] mapS = new int[256];
            int[] mapT = new int[256];
            for(int i = 0 ; i < s.length() ; i++){
                char s1 = s.charAt(i);
                char t1 = t.charAt(i);

                if(mapS[s1] != mapT[t1])
                  return false;
                
                mapS[s1] = i+1;
                mapT[t1] = i + 1;
            }
        }
        return true;
    }
}