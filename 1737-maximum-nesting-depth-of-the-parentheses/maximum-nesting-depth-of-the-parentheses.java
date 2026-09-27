class Solution {
    public int maxDepth(String s) {
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
    }
}