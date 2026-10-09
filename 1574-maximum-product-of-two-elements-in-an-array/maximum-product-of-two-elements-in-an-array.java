class Solution {
    public int maxProduct(int[] nums) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for(int num : nums){
            if(num > first){
                second = first;
                first = num;
            }
            else if(second < num){
                second = num;
            }
        }
        //System.out.print(first);
        //System.out.print(second);

        return (first - 1) * (second - 1);
    }
}