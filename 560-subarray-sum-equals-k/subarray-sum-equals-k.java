class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer , Integer> map = new HashMap<>();
        map.put(0 , 1);
        int count = 0 ;
        int currentsum = 0 ;

        for(int num : nums){
            currentsum += num;
            if(map.containsKey(currentsum - k))
              count += map.get(currentsum-k);

           map.put(currentsum , map.getOrDefault(currentsum , 0) + 1);
        }

        return count;
    }
}