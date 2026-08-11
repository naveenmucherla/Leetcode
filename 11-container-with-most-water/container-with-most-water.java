class Solution {
    public int maxArea(int[] height) {
        int i = 0 ;
        int j = height.length-1;
        int result = 0;
        int maxresult = 0;
        while(i < j){
            result = (j-i) * Math.min(height[i] , height[j]);
            maxresult = Math.max(maxresult , result);
            if(height[i] < height[j])
               i++;
            else
              j--;
        }
        return maxresult;
    }
}