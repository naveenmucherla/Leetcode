class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        // Initialize all elements in the result array to -1
        Arrays.fill(res, -1);
        
        // Stack to store indices of the elements
        Stack<Integer> stack = new Stack<>();
        
        // Traverse the array twice to simulate the circular behavior
        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];
            
            // While the stack is not empty and the current element is greater 
            // than the element at the index stored at the top of the stack
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                int popIdx = stack.pop();
                res[popIdx] = num;
            }
            
            // We only need to push indices to the stack during the first pass
            if (i < n) {
                stack.push(i);
            }
        }
        
        return res;
    }
}
