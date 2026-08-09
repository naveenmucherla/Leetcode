class Solution {
    public int maxProduct(int[] nums) {
        int maxproduct = 0;
        int product = 0;
        int prefix_product = 1 ;
        int suffix_product = 1;
        int n = nums.length;
        if(nums.length == 1){
            maxproduct = nums[0];
        }
        else{
        for(int i = 0 ; i < n; i++){
            if(prefix_product == 0)
              prefix_product = 1;
            if(suffix_product == 0)
              suffix_product = 1;
            
            prefix_product *= nums[i];
            suffix_product *= nums[n - 1 - i];

            product = Math.max(prefix_product , suffix_product);
            maxproduct = Math.max(maxproduct , product);
        }
        }
        return maxproduct;
    }
}