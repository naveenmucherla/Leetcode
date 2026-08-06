class Solution {
    public int trap(int[] height) {
        int left = 0 ;
        int right = height.length-1;
        int i = 0;
        int j = 0;
        int water = 0;

        while(left < right){
        if(height[left] < height[right]){
            if(height[left] >= i)
               i = height[left];
            else
              water += i - height[left];
            
            left++;
        }
        else{
            if(height[right] >= j)
              j = height[right];
            else
              water += j - height[right];
            
            right--;
        }

        }
        return water;
        
    }
}