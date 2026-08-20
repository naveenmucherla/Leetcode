class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Stack<Integer> stack = new Stack<Integer>();

        for(int day = 0 ; day < temperatures.length ; day++){
            while(!stack.isEmpty() && temperatures[day] > temperatures[stack.peek()]){
                int older = stack.pop();
                answer[older] = day - older;
            }
            stack.push(day);
        }
        return answer;
    }
}