class Solution {
    public int maxDepth(String s) {
       int count = 0,max = 0;
       for(int i = 0 ; i < s.length() ; i++){
         char ch = s.charAt(i);
         if(ch == '('){
            count++;
         }
         else if(ch == ')'){
            count--;
         }
         max = Math.max(max , count);
       }
       return max;
    }
}
/*
 Stack<Character> stack = new Stack<>();
        int max = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(ch);
            }
            else if(ch == ')'){
                stack.pop();
            }
            max = Math.max(max , stack.size());
        }
        return max;
*/