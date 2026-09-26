class Solution {
    public boolean divideArray(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num , map.getOrDefault(num , 0)+1);
        }
        System.out.println(map);
        for(int num : map.keySet()){
            if(map.get(num) % 2 != 0)
             return false;
        }
        return true;
    }
}