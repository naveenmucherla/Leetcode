class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer , Integer> map = new HashMap<>();
        for(int num : arr){
            map.put(num , map.getOrDefault(num , 0) + 1);
        }
        System.out.println(map);
       Set<Integer> hash = new HashSet<>(map.values());
        return hash.size() == map.size();
    }
}