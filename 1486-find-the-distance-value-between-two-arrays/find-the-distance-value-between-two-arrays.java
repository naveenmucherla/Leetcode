class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int distence = 0;
        for(int num : arr1){
            int loweval = num - d;
            int upperval = num + d;

            if(!hasBounded(arr2 , loweval , upperval)){
                distence++;
            }
        }
        return distence;
    }
    private boolean hasBounded(int[] arr , int lower , int upper){
        int left = 0 , right = arr.length -1;
        while(left <= right){
            int mid = left + (right - left) / 2;

            if(arr[mid] >= lower &&  arr[mid] <= upper){
                return true;
            }
            else if(arr[mid] < lower){
                left = mid + 1;
            }
            else {
                right = mid -1;
            }
        }
        return false;
    }
}