class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            if(stack.isEmpty() || stack.peek() != c)
              stack.push(c);
            else
              stack.pop();
        }
        StringBuilder result = new StringBuilder();
        for(int i = 0 ; i < stack.size() ; i++)
          result.append(stack.get(i));
        return result.toString();
    }
}