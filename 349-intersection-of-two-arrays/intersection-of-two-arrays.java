class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> map = new HashSet<>();
        for(int i : nums1){
            map.add(i);
        }
        for(int i : nums2){
            if(map.contains(i)){
                list.add(i);
                map.remove(i);
            }
        }
       // System.out.println(list);
       int[] arr = new int[list.size()];
       for(int i = 0 ; i < arr.length ; i++){
        arr[i] = list.get(i);
       }
        return arr;
    }
}