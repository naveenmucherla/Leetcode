class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            if(c == '1')
            list.add(i);
        }
        if(list.size() < k){
            return "";
        }
        int minlength = Integer.MAX_VALUE;
        String result = "";
        for(int i = 0 ; i <= list.size() - k ; i++){
           int start = list.get(i);
           int end = list.get(i + k - 1);
           int currentsize = end - start + 1;
           String currentsubstring = s.substring(start , end + 1);
            if(currentsize < minlength){
                minlength = currentsize;
                result = currentsubstring;
            }
            else if(minlength == currentsize){
                if(currentsubstring.compareTo(result) < 0){
                    result = currentsubstring;
                }
            }
        }
        return result;
    }
}