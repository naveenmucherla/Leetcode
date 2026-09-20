import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        // Push -1 as the initial base/boundary index
        stack.push(-1); 
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                // Always push the index of an opening parenthesis
                stack.push(i);
            } else {
                // Pop the top element for a matching ')'
                stack.pop();

                if (stack.isEmpty()) {
                    // If empty, the current ')' has no matching '('
                    // It becomes the new boundary base index
                    stack.push(i);
                } else {
                    // If not empty, calculate the valid substring length
                    int currentLength = i - stack.peek();
                    maxLength = Math.max(maxLength, currentLength);
                }
            }
        }

        return maxLength;
    }
}
