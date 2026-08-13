class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> str = new HashSet<>();
        int left = 0 ;
        int maxcount = 0;
        for(int right = 0 ; right < s.length() ; right++){
            char c = s.charAt(right);

            while(str.contains(c)){
                str.remove(s.charAt(left));
                left++;
            }
            str.add(c);
           maxcount = Math.max(maxcount , right - left + 1);
        }
        return maxcount;
    }
}