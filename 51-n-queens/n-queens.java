class Solution {
   private List<List<String>> result;
   private boolean[] cols;
   private boolean[] dia1;
   private boolean[] dia2;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        cols = new boolean[n];
        dia1 = new boolean[2 * n];
        dia2 = new boolean[2 * n];

        char[][] board = new char[n][n];
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(board[i] , '.');
        }
        backtrack(0 , n , board);
        return result;
    }
    private void backtrack(int row , int n , char[][] board){
        if(row == n){
            result.add(construct(board));
            return;
        }
        for(int col = 0 ; col < n ; col++){
           if(cols[col] || dia1[row - col + n] || dia2[row + col]){
           continue;
           }
           board[row][col] = 'Q';
           cols[col] = true;
           dia1[row - col + n] = true;
           dia2[row + col] = true;

           backtrack(row + 1 , n , board);

           board[row][col] = '.';
           cols[col] = false;
           dia1[row - col + n] = false;
           dia2[row + col] = false;

           
        }
    }
    private List<String> construct(char[][] board){
        List<String> path = new ArrayList<>();
        for(int i = 0 ; i < board.length ; i++){
            path.add(new String(board[i]));
        }
        return path;
    }
}