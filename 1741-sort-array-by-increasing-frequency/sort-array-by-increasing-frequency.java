class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num , map.getOrDefault(num , 0) + 1);
        }
        //System.out.println(map);
        List<Integer> list = new ArrayList<>(map.keySet());
        List<Integer> li = new ArrayList<>();
        list.sort((a , b) ->{ int freq1 = map.get(a);
                              int freq2 = map.get(b);
                              return (freq1 == freq2) ? (b-a) : (freq1 - freq2);
                              });

        int[] arr = new int[nums.length];
        int index = 0;
        for(int num : list){
            int count = map.get(num);
            for(int i = 0 ; i < count ; i++){
               arr[index++] = num;
            }
        }
        return arr;
    }
}