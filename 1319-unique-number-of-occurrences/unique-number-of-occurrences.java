class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:arr){
             if(map.containsKey(num)){
                 map.put(num,map.get(num)+1);
             }
             else{
                map.put(num,0);
             }
        }
        HashSet<Integer> set=new HashSet<>();
        for(int i:map.keySet()){
            if(set.contains(map.get(i))){
               return false;
            }
          set.add(map.get(i));
        }
        return true;
    }
}