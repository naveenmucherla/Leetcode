class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character ,Integer> map = new HashMap<>(32 , 0.75f);
        int n = s.length();
        if(s.length() != t.length())
            return false;
        for(int i = 0 ; i < n ; i++){
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c , 0) + 1);
        }

        for(int i = 0 ; i < n ; i++){
            char c = t.charAt(i);
            if(!map.containsKey(c))
              return false;
            
            int count = map.get(c) - 1;

            if(count == 0){
                map.remove(c);
            }
            else{
                map.put(c , count);
            }
        }
        return map.isEmpty();
    }
}