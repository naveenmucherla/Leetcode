class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[')
              stack.push(c);

            if(stack.isEmpty()) return false;
            if(c == ')' && stack.peek() == '(')
              stack.pop();
            else if( c == ')' && stack.peek() != '(')
              stack.push(c);

            if(c == ']' && stack.peek() == '[' ){
              stack.pop();
            }
            else if(c == ']' && stack.peek() != '['){
                stack.push(c);
            }

            if(c == '}' && stack.peek() == '{')
              stack.pop();
            else if(c == '}' && stack.peek() != '{')
              stack.push(c);
        }
        return stack.isEmpty();
    }
}