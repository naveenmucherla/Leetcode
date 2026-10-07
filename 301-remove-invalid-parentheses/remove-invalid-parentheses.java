class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) return result;
        
        // Queue for BFS and Set to track visited strings to avoid duplicates
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.add(s);
        visited.add(s);
        
        boolean foundValid = false;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            // Process the current level completely
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                
                // If the current string is valid, add it to our result list
                if (isValid(current)) {
                    result.add(current);
                    foundValid = true;
                }
                
                // If a valid string is found at this level, do not generate the next level
                if (foundValid) continue;
                
                // Generate all possible states by removing one parenthesis at a time
                for (int j = 0; j < current.length(); j++) {
                    char c = current.charAt(j);
                    
                    // Skip if the character is a letter
                    if (c != '(' && c != ')') continue;
                    
                    // Form the new candidate string by removing the character at index j
                    String candidate = current.substring(0, j) + current.substring(j + 1);
                    
                    if (!visited.contains(candidate)) {
                        visited.add(candidate);
                        queue.add(candidate);
                    }
                }
            }
            
            // Stop BFS if we found the minimum removal valid strings at the current level
            if (foundValid) break;
        }
        
        return result;
    }
     private boolean isValid(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
                if (count < 0) return false; // More closing than opening at any point
            }
        }
        return count == 0;
    }
}