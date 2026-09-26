class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String , String> map = new HashMap<>();
        StringBuilder  sb = new StringBuilder();
        for(List<String> st : knowledge){
            map.put(st.get(0), st.get(1));
        }
        int i = 0;
       while(i < s.length()){
            char c = s.charAt(i);
            if(c == '('){
                int j = i+ 1;
                while(j < s.length() && s.charAt(j) != ')'){
                    j++;
                }
                String key = s.substring(i + 1, j);
                sb.append(map.getOrDefault(key , "?"));
                i = j + 1; 
            }
            else{
                sb.append(c);
                i++;
            }
        }
        return sb.toString();
    }
}