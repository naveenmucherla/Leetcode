class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0 ;
        int j = numbers.length-1;
        int k = 0 ;
        int l = 0;
        while(i < j){
            if(numbers[i] + numbers[j] == target){
                k = i + 1;
                l = j +1;
                break;
            }
            else if(numbers[i] + numbers[j] < target){
                i++;
            }
            else
              j--;
        }
        return new int[]{k , l};
    }
}