class Solution {
    public int countOdds(int low, int high) {
        int count = 0;
        boolean lowodd = low % 2 == 0 ? true : false;
        boolean highodd = high % 2 == 0 ? true : false;
        if(lowodd & highodd){
            count = (high - low) / 2;
        }
        else{
            count = (high - low) / 2 + 1;
        }
        return count;
    }
}