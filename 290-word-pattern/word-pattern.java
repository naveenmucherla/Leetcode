class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(words.length != pattern.length() || s == null || pattern == null){
            return false;
        }

        HashMap<Character , String> hash = new HashMap<>();
        HashSet<String> set = new HashSet<>();

        for(int i = 0 ; i < pattern.length() ; i++){
            char ch = pattern.charAt(i);
            String word = words[i];
            if(hash.containsKey(ch)){
                if(!hash.get(ch).equals(word)){
                    return false;
                }
            }
            else{
                if(set.contains(word)){
                    return false;
                }
            }
            hash.put(ch , word);
            set.add(word);
        }
        return true;
    }
}