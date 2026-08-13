class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s == null || p == null || s.length() < p.length()){
            return result;
        }
        int[] pcount = new int[26];
        int[] scount = new int[26];

        for(int i = 0 ; i < p.length() ; i++){
            pcount[p.charAt(i) - 'a']++;
            scount[s.charAt(i) - 'a']++;
        }
       
        if(matches(pcount , scount)){
            result.add(0);
        }
        
        for(int left =0 ; left < s.length()- p.length() ; left++){
            int right = left + p.length();
            scount[s.charAt(right) - 'a']++;

            scount[s.charAt(left) - 'a']--;

            if(matches(pcount , scount)){
                result.add(left + 1);
            }
        }

      return result;
    }
    private boolean matches(int[] a , int[] b){
            for(int i = 0 ; i < a.length ; i++){
                if(a[i] != b[i])
                  return false;
            }
            return true;
    }
}