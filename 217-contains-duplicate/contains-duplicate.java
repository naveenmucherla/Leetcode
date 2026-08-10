class Solution {
    public boolean containsDuplicate(int[] nums) {
       HashMap<Integer,Integer> map = new HashMap<>(32 , 0.75f);

       for(int num : nums){
           if(map.containsKey(num)){
               return true;
            }
            map.put(num , num);
       }
       return false;
    }
}