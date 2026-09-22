class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : nums1){
            map.put(i , map.getOrDefault(i , 0) + 1);
        }
        for(int i : nums2){
            if(map.containsKey(i)){
                map.put(i , map.get(i) - 1);
                if(map.get(i) <= 0){
                    map.remove(i);
                }
                list.add(i);
            }
        }
        System.out.println(map);
       int[] arr = new int[list.size()];
       for(int i = 0 ; i < arr.length ; i++){
        arr[i] = list.get(i);
       }
        return arr;
    }
}