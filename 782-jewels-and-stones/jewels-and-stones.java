class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashMap<Character , Integer> hash = new HashMap<>();
        for(int i = 0 ; i < stones.length() ; i++){
            char ch = stones.charAt(i);
            hash.put(ch , hash.getOrDefault(ch , 0)+1);
        }
        System.out.println(hash);
        int count =0;
        for(int i = 0 ; i < jewels.length() ; i++){
            char ch = jewels.charAt(i);
            if(hash.containsKey(ch)){
                count += hash.get(ch);
                hash.remove(ch);
                System.out.println(hash);
            }
        }
        return count;
    }
}