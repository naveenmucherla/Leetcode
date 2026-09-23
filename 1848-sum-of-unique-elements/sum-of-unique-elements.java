class Solution {
    public int sumOfUnique(int[] nums) {
        HashMap<Integer , Integer> set = new HashMap<>();
        int sum =0;
        for(int num :  nums){
           set.put(num , set.getOrDefault(num , 0) + 1);
        }
        System.out.println(set);
        for(int num : set.keySet()){
            if(set.get(num) == 1){
                sum += num;
            }
        }
        return sum;
    }
}