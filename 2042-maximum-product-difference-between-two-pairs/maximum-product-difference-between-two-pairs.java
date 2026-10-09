class Solution {
    public int maxProductDifference(int[] nums) {
        int high = Integer.MIN_VALUE;
        int shigh = Integer.MIN_VALUE;

        int low = Integer.MAX_VALUE;
        int slow = Integer.MAX_VALUE;

        for(int num : nums){
            if(high < num){
                shigh = high;
                high = num;
            }
            else if(shigh < num){
                shigh = num;
            }
            
           if(low > num){
                slow = low;
                low = num;
            }
            else if(slow > num){
                slow = num;
            }
        }
        System.out.println(high);
        System.out.println(shigh);
        System.out.println(low);
        //System.out.println(slow);
        return (high * shigh) - (low * slow);
    }
}