class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0 ;
        int[] arr = new int[nums1.length + nums2.length];
        
        int i = 0 ;
        int j = 0 ;
        int k = 0;
        while( i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                arr[k] = nums1[i];
                i++;
                k++;
            }
            else{
              arr[k] = nums2[j];
              j++;
              k++;
            }
              
        }
        while(i != nums1.length && k != arr.length)
          arr[k++] = nums1[i++];
        
        while(j != nums2.length && k != arr.length)
          arr[k++] = nums2[j++];
        
        double n = Math.floor(arr.length / 2);
        if(arr.length % 2 == 0){
            double m1 = arr[((int) n)] ;
            double m2 = arr[((int) n - 1)];
            median = (m1 + m2)/2;
        }
        else
          median = arr[(int) n];
        
      return median;
    }
}