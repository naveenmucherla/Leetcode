class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0 ; i < nums1.length ; i++){
            int elem = Find(nums1[i] , nums2);
            stack.push(elem);
        }
        int[] arr = new int[nums1.length];
        for(int num = 0;num < stack.size() ; num++){
           arr[num] = stack.get(num);
        }
       return arr;
    }
    private int Find(int num , int[] arr){
        int b = -1;
        for(int i = 0 ; i < arr.length ; i++){
            if(num == arr[i]){
                for(int j = i + 1 ; j < arr.length ; j++){
                    if(arr[j] > num){
                        b = arr[j];
                        break;
                    }
                }
            }
        }
        return b;
    }
}