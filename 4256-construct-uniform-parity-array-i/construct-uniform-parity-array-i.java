class Solution {
    public boolean uniformArray(int[] nums1) {
        int count = 0;
        int[] nums2 = new int[nums1.length];
        for(int i = 0 ; i < nums1.length-1 ; i++){
            int j = i + 1;
            if(nums1[i] - nums1[j] % 2 == 0){
              count++;
              nums2[i] = nums1[i] - nums1[j];
            }
            else if(count == 0 && nums1[i] - nums1[j] % 2 != 0){
                nums2[i] = nums1[i] - nums2[j];
            }
           else if(j == nums1.length-1){
            nums2[j] = nums1[j];
           }
        }
        if(nums1.length == nums2.length)
         return true;

        return false;
    }
}