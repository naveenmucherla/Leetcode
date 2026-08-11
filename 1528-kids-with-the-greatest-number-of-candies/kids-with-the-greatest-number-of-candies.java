class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList<Boolean> list = new ArrayList<>();
        int max = 0 ;
        int Tmax = 0 ;
        for(int can : candies){
            max = can;
            Tmax = Math.max(Tmax , max);
        }

        for(int can : candies){
            if(can + extraCandies >= Tmax){
                list.add(true);
            }
            else
              list.add(false);
        }
        return list;
    }
}