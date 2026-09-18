class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] arr = new int[k];
        HashMap<Integer , Integer> map = new HashMap<>(32, 0.75f);

        for(int num : nums){
            map.put(num , map.getOrDefault(num , 0) + 1);
        }
        List<Integer>[] bucket = new List[nums.length+1];
        for(int key : map.keySet()){
            int frequency = map.get(key);
            if(bucket[frequency] == null)
              bucket[frequency] = new ArrayList<>();
            
            bucket[frequency].add(key);

        }
        int index = 0 ;
        for(int i = nums.length ; i >= 0 && index < k ; i--){
            if(bucket[i] != null){
                for(int num : bucket[i]){
                    arr[index++] = num;
                    if(index == k) return arr;
                }
            }
        } 
        
        return arr;
    }
}