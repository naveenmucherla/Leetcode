class Solution {
    public int minInsertions(String s) {
        int open = 0 ;
        int insert = 0;

        for(char ch : s.toCharArray()){
            if(ch == '('){
                open += 2;

                if(open % 2 != 0){
                    insert++;
                    open--;
                }
            }
            else{
                open--;
                if(open < 0){
                    insert++;
                    open += 2;
                }
            }

        }
        return insert + open;
    }
}