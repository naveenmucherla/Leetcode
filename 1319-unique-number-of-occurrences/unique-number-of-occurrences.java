class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer , Integer> map = new HashMap<>();
        for(int num : arr){
            map.put(num , map.getOrDefault(num , 0) + 1);
        }
        System.out.println(map);
       Set<Integer> hash = new HashSet<>();
       for(int num : map.keySet()){
            if(hash.contains(map.get(num))){
                return false;
            }
            hash.add(map.get(num));
       }
        return true;
    }
}