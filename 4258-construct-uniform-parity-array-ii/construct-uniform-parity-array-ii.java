class Solution {
    public boolean uniformArray(int[] nums1) {
       int min = nums1[0];
       for(int num : nums1){
       min = Math.min(min , num);
       }
       for(int num : nums1){
        if(num % 2 != min % 2){
            return min % 2 != 0;
        }
        
       }
       return true;
    }
}