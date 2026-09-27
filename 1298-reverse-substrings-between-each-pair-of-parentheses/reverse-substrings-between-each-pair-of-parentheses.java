class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0 ; i < sb.length() ; i++){
            char ch = sb.charAt(i);
            if(ch == '('){
                stack.push(i);
            }
            else if(ch == ')'){
                int start = stack.pop();
                reverse(sb ,start + 1, i -1 );
            }
        }
        StringBuilder ss = new StringBuilder();
        for(int i = 0 ; i < sb.length() ; i++){
            char c = sb.charAt(i);
            if(c != '(' && c != ')'){
                ss.append(c);
               // System.out.print(ss + " ");
            }
        }
       return ss.toString();
    }
    public static void reverse(StringBuilder sb , int left , int right){
        while(left < right){
                char temp = sb.charAt(left);
                sb.setCharAt(left , sb.charAt(right));
                sb.setCharAt(right, temp);
                left++;
                right--;
            }
        //System.out.println(sb);
    }
}