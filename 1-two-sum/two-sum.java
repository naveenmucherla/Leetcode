class Solution {
    public int[] twoSum(int[] nums, int target) {
     Map<Integer , Integer> map = new HashMap<>();

      for(int i = 0 ; i < nums.length ; i++){
          int num1 = nums[i];
          int num2 = target-num1;

          if(map.containsKey(num2) == true){
            int j = map.get(num2);
            return new int[]{i , j};
          }
          map.put(num1 , i);
      }
     return nums;
    }
}