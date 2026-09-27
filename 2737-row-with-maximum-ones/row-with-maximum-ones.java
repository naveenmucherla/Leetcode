class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int count = 0;
        int index = 0;
        int max = 0;
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
               if(mat[i][j] == 1){
                max++;
               }
            }
            int cou = count;
            count = Math.max(count , max);
            if(cou != count){
                index = i;
            }
            max = 0;
           // System.out.print(cou + " ");
        }
        //System.out.println(count);
        return new int[]{index , count};
    }
}