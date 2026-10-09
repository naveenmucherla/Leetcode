class Solution {
    public String smallestSubsequence(String s) {
        int[] count = new int[26];
        boolean[] visited = new boolean[26];

        for(int i = 0; i < s.length() ; i++){
            char ch = s.charAt(i);
            count[ch - 'a']++;
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            int idx = ch - 'a';
            count[idx]--;
            if(visited[idx]){
                continue;
            }
            while(!stack.isEmpty() && stack.peek() > ch && count[stack.peek() - 'a'] > 0){
                char removed = stack.pop();
                visited[removed - 'a'] = false;
            }
            stack.push(ch);
            visited[ch - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        for(char vh : stack){
            sb.append(vh);
        }
        return sb.toString();
    }
}