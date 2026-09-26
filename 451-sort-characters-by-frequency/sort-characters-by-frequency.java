class Solution {
    public String frequencySort(String s) {
        HashMap<Character , Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch , map.getOrDefault(ch , 0) + 1);
        }
        List<Character> character = new ArrayList<>(map.keySet());
        StringBuilder sb = new StringBuilder();
        character.sort((a , b) -> map.get(b) - map.get(a));
       // System.out.println(character);
        for(char ch : character){
            int count = map.get(ch);
            for(int i = 0 ; i < count ; i++){
              sb.append(ch);
            }
        }
        //System.out.println(map);
        return sb.toString();
    }
}