class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer , Integer> hash = new HashMap<>();

        for(int num : arr){
            hash.put(num , hash.getOrDefault(num , 0) + 1);
        }
        //System.out.println(hash);
        int res = -1;
        for(int num : hash.keySet()){
            if(num == hash.get(num)){
               res = Math.max(res , num);
            }
        }
        return res;
    }
}